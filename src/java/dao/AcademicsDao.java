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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.HigherAcademics;
import model.SchoolAcademic;

/**
 *
 * @author SarthakJ
 */
public class AcademicsDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean addLAcademics(SchoolAcademic sac, ServletContext context) {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr1="select class from schoolacademic where eusername=?";
            ps=con.prepareStatement(qr1);
            ps.setString(1,sac.getEusername());
            rs=ps.executeQuery();
            if(rs.next()){
            String qr="update schoolacademic set school=?,class=?,percent=?,board=? where eusername=?";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,sac.getSchool());
            ps.setString(2,sac.getClassSch());
            ps.setFloat(3,sac.getPercentage());
            ps.setString(4,sac.getBoard());
            ps.setString(5,sac.getEusername());
            
            if(ps.executeUpdate()>0)
                return true;
            }
            else
            {
                String qr="insert into schoolacademic values(?,?,?,?,?)"; 
                 ps=con.prepareStatement(qr);
                 ps.setString(5,sac.getEusername());
            ps.setString(1,sac.getSchool());
            ps.setString(2,sac.getClassSch());
            ps.setFloat(3,sac.getPercentage());
            ps.setString(4,sac.getBoard());
            
            if(ps.executeUpdate()>0)
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean addMAcademics(SchoolAcademic sac, ServletContext context) {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr1="select class from schoolacademic where eusername=?";
            ps=con.prepareStatement(qr1);
            ps.setString(1,sac.getEusername());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(rs.getInt(1)==11){
            String qr="update schoolacademic set school=?,class=?,percent=?,board=? where eusername=?";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,sac.getSchool());
            ps.setString(2,sac.getClassSch());
            ps.setFloat(3,sac.getPercentage());
            ps.setString(4,sac.getBoard());
            ps.setString(5,sac.getEusername());
            
            if(ps.executeUpdate()>0)
                return true;
            }
                else
                {
                String qr="insert into schoolacademic values(?,?,?,?,?)"; 
                 ps=con.prepareStatement(qr);
                 ps.setString(5,sac.getEusername());
            ps.setString(1,sac.getSchool());
            ps.setString(2,sac.getClassSch());
            ps.setFloat(3,sac.getPercentage());
            ps.setString(4,sac.getBoard());
            
            if(ps.executeUpdate()>0)
                return true;
                }
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(AcademicsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean addHAcademics(HigherAcademics hac, ServletContext context) {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="insert into highereducation values(?,?,?,?,?)";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,hac.getCollege());
            ps.setString(2,hac.getCoursename());
            ps.setFloat(3,hac.getSgpa());
            ps.setFloat(4,hac.getCgpa());
            ps.setString(5,hac.getEusername());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AcademicsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getClassInfo(String euname, ServletContext context) {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select class from schoolacademic where eusername=?";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,euname);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                return rs.getInt(1);
            }
            else
            {
                return 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AcademicsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 1;
    }
    
    
}
