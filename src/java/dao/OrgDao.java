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
import model.OrganizationModel;
import model.UserModel;

/**
 *
 * @author SarthakJ
 */
public class OrgDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void getOrgNames(ArrayList<OrganizationModel> alstr,ServletContext context)
    {
        try {
            
            con=(Connection) context.getAttribute("datacon");
            String qr="select orgname,oid from organizations order by orgname";
            
            ps=con.prepareStatement(qr);
            
            rs=ps.executeQuery();
            OrganizationModel om=null;
            while(rs.next())
            {
                om=new OrganizationModel();
                om.setOrgName(rs.getString(1));
                om.setOid(rs.getInt(2));
                alstr.add(om);
            }
   
        } catch (SQLException ex) {
            Logger.getLogger(OrgDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    public boolean insertOrganization(OrganizationModel om,ServletContext context)
    {
        try {
            con=(Connection) context.getAttribute("datacon");
            String qr="insert into organizations(orgname,orgtype,ownereusername,email,contactno,city,address,state,noofemp) values(?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(qr);
            ps.setString(1,om.getOrgName());
            ps.setString(2,om.getOrgType());
            ps.setString(3,om.getOwUName());
            ps.setString(4,om.getEmail());
            ps.setString(5,om.getContact());
            ps.setString(6,om.getCity());
            ps.setString(7,om.getAddress());
            ps.setString(8,om.getState());
            ps.setInt(9,om.getEmpNo());
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(OrgDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

   public ArrayList<OrganizationModel> getEmpOrg(UserModel um, ServletContext context) 
    {
        try {
            ArrayList<OrganizationModel> orgList=new ArrayList<>();
            con=(Connection) context.getAttribute("datacon");
            String qr=" select employees.oid,orgname from organizations inner join employees where eusername=? and employees.oid=organizations.oid and status='true'";
            ps=con.prepareStatement(qr);
            ps.setString(1,um.getEusername());
            rs=ps.executeQuery();
            
            OrganizationModel om=null;
            while(rs.next())
            {
                om=new OrganizationModel();
                om.setOid(rs.getInt(1));
                om.setOrgName(rs.getString(2));
                orgList.add(om);
            }
            return orgList;
        } catch (SQLException ex) {
            Logger.getLogger(OrgDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
