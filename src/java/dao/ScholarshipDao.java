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
import model.SchSchemeModel;

/**
 *
 * @author SarthakJ
 */
public class ScholarshipDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public ArrayList<SchSchemeModel> fetchScholarshipSch(String eusername, ServletContext context) {
        
        ArrayList<SchSchemeModel> alsch=new ArrayList<>();
        try {
            System.out.println("in dao");
            con=(Connection)context.getAttribute("datacon");
            String qr="select * from scholarships where oid in (select oid from employees where eusername=? and status='true')";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,eusername);
            
            rs=ps.executeQuery();
            
            SchSchemeModel sch;
            while(rs.next())
            {
                sch=new SchSchemeModel();
                
                sch.setSid(rs.getInt(1));
                sch.setNameSch(rs.getString(2));
                sch.setOid(rs.getInt(3));
                sch.setAmt(rs.getInt(4));
                sch.setHowA(rs.getString(5));
                sch.setDeadLine(rs.getString(6));
                sch.setOtherD(rs.getString(7));
                sch.setPercent(rs.getFloat(8));
                sch.setCat(rs.getString(9));
                sch.setIncome(rs.getInt(10));
                sch.setAbove(rs.getString(11));
                sch.setUpto(rs.getString(12));
                
                alsch.add(sch);
            }
            
            return alsch;
        } catch (SQLException ex) {
            Logger.getLogger(ScholarshipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addScheme(SchSchemeModel sch, ServletContext context) {
        
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="insert into scholarships(nameofscheme,oid,amt,howtoapply,deadline,otherdetails,percent,category,income,above,upto) values(?,?,?,?,?,?,?,?,?,?,?)";
            
            ps=con.prepareStatement(qr);
            
            ps.setString(1,sch.getNameSch());
            ps.setInt(2,sch.getOid());
            ps.setInt(3,sch.getAmt());
            ps.setString(4,sch.getHowA());
            ps.setString(5,sch.getDeadLine());
            ps.setString(6,sch.getOtherD());
            ps.setFloat(7,sch.getPercent());
            ps.setString(8,sch.getCat());
            ps.setInt(9,sch.getIncome());
            ps.setString(10,sch.getAbove());
            ps.setString(11,sch.getUpto());
            
            if(ps.executeUpdate()>0)
                return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ScholarshipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
}
