/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.EmpModel;
import model.EmpUserModel;
import model.UserModel;

/**
 *
 * @author SarthakJ
 */
public class EmpDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean addEmp(EmpModel em,ServletContext context)
    {
        try {
            con=(Connection) context.getAttribute("datacon");
            String qr="insert into employees values(?,?,?,?)";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,em.geteUserName());
            ps.setInt(2,em.getOid());
            ps.setString(3,em.getDesignation());
            ps.setString(4,"false");
            
            if(ps.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean isEmp(String eusername, ServletContext context) 
    {
        try {
            con=(Connection) context.getAttribute("datacon");
            String qr="select eusername from employees where eusername=?";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,eusername);
            
            rs=ps.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<EmpUserModel> fetchEmpRequests(UserModel um,ServletContext context)
    {
          con=(Connection) context.getAttribute("datacon");
          String qr="select name,designation,users.contactno,users.email,orgname,users.eusername,employees.oid from users inner join employees on users.eusername=employees.eusername inner join organizations where organizations.oid=employees.oid and organizations.oid in(select oid from organizations where ownereusername=?) and status='false'";
        try {
            ps=con.prepareStatement(qr);
            ps.setString(1,um.getEusername());
            rs=ps.executeQuery();
            EmpUserModel eum=null;
            ArrayList<EmpUserModel> aleum=new ArrayList<>();
            while(rs.next())
            {
                eum=new EmpUserModel();
                eum.setName(rs.getString(1));
                eum.setDesignation(rs.getString(2));
                eum.setContactno(rs.getString(3));
                eum.setEmail(rs.getString(4));
                eum.setOrgname(rs.getString(5));
                eum.setEusername(rs.getString(6));
                eum.setOid(rs.getString(7));
                aleum.add(eum);
            }
            return aleum;
            //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean giveDecision(String dec, String eusername,String oid, ServletContext context) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            con=(Connection) context.getAttribute("datacon");
            String qr="update employees set status=? where eusername=? and oid=?";
            ps=con.prepareStatement(qr);
            
            if(dec.trim().equals("accept"))
            {
                ps.setString(1,"true");
                ps.setString(2,eusername);
                ps.setString(3,oid);
            }
            else if(dec.trim().equals("reject"))
            {
                ps.setString(1,"reject");
                ps.setString(2,eusername);
                ps.setString(3,oid);
            }
           return(ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     
}
