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
import javax.servlet.http.HttpSession;
import model.DeathModel;
import model.UserModel;

/**
 *
 * @author rohan
 */
public class UserDao {

    private Connection con;
    private PreparedStatement ps,ps1;
    private ResultSet rs,rs1;
    
    public boolean verifyUser(UserModel um, ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select * from users where eusername=? and password=?";
            ps=con.prepareStatement(qr);
            ps.setString(1,um.getEusername());
            ps.setString(2,um.getPassword());
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                um.setEusername(rs.getString(1));
                um.setAadhar(rs.getInt(2));
                um.setName(rs.getString(3));
                um.setDob(rs.getString(4));
                um.setContact(rs.getInt(5));
                um.setEmail(rs.getString(6));
                um.setIncome(rs.getInt(7));
                um.setFathername(rs.getString(8));
                um.setPassword(rs.getString(9));
                um.setGender(rs.getString(10));
                um.setCity(rs.getString(11));
                um.setAddress(rs.getString(12));
                um.setCategory(rs.getString(13));
                um.setState(rs.getString(14));
                
            return true;
            }
           
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
       return false;
    }

    public boolean insertUser(UserModel um,ServletContext context)
    {
        try {
            con=(Connection) context.getAttribute("datacon");
            String qr="insert into users(eusername,aadhar,name,dob,contactno,email,fathersname,password,state,city,address,gender) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(qr);
            ps.setString(1,um.getEusername());
            ps.setInt(2,um.getAadhar());
            ps.setString(3,um.getName());
            ps.setString(4,um.getDob());
            ps.setInt(5,um.getContact());
            ps.setString(6,um.getEmail());
            ps.setString(7,um.getFathername());
            ps.setString(8,um.getPassword());
            ps.setString(9,um.getState());
            ps.setString(10,um.getCity());
            ps.setString(11,um.getAddress());
            ps.setString(12,um.getGender());
            //ps.setString(13,"alive");
            
           
                return(ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
    
     public boolean checkFamily(UserModel um, ServletContext context) 
    {
        try {
            con=(Connection) context.getAttribute("datacon");
            
            String qr="select name from users where aadhar=? and name=? and dob=?";
            ps=con.prepareStatement(qr);
            ps.setInt(1,um.getAadhar());
            ps.setString(2,um.getName());
            ps.setString(3,um.getDob());
            
            rs=ps.executeQuery();
            
            return(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }

    public boolean insertFamily(UserModel um, UserModel um1, ServletContext context) 
    {
        try {
            con=(Connection) context.getAttribute("datacon");
            String qr="insert into familyinfo values(?,?)";
            ps=con.prepareStatement(qr);
            ps.setString(1,um1.getEusername());
            ps.setString(2,um.getEusername());
            
            return(ps.executeUpdate()>0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    return false;
    }

    public boolean showFamily(UserModel um, ServletContext context, ArrayList<UserModel> umal) 
    {
         try {
            con=(Connection) context.getAttribute("datacon");
          
          String userid=um.getEusername();
          String qr1="select rel2eusername from familyinfo where rel1eusername=?";
          ps=con.prepareStatement(qr1);
          ps.setString(1,userid);
          rs=ps.executeQuery();
            UserModel um1 =null;
            while(rs.next())
            {
              um1=new UserModel(); 
              
              String qr2="select aadhar,name,dob from users where eusername=?";
              ps=con.prepareStatement(qr2);
              ps.setString(1,rs.getString(1));
              rs1=ps.executeQuery();
                
                while(rs1.next())
                {
                    um1.setAadhar(Integer.parseInt(rs1.getString(1)));
                    um1.setName(rs1.getString(2));
                    um1.setDob(rs1.getString(3));
                }
                
                umal.add(um1);
            }
            
           System.out.println("first"+umal);
          String qr2="select rel1eusername from familyinfo where rel2eusername=?";
          ps=con.prepareStatement(qr2);
          ps.setString(1,userid);
          rs=ps.executeQuery();  
          
            while(rs.next())
            {
              um1=new UserModel(); 
              
              String qr3="select aadhar,name,dob from users where eusername=?";
              ps=con.prepareStatement(qr3);
              ps.setString(1,rs.getString(1));
              rs1=ps.executeQuery();
                
                while(rs1.next())
                {
                    um1.setAadhar(Integer.parseInt(rs1.getString(1)));
                    um1.setName(rs1.getString(2));
                    um1.setDob(rs1.getString(3));
                }
                
                umal.add(um1);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    return false;

    
    }

    public boolean insertDeathInfo(DeathModel dm, ServletContext context, HttpSession session) 
       {
            try {
            con=(Connection) context.getAttribute("datacon");
            
            String qr="insert into deathinfo values(?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(qr);
            ps.setString(1,dm.getEusername());
            ps.setString(2,dm.getDeathdate());
            ps.setString(3,dm.getPlace());
            ps.setString(4,dm.getCause());
            ps.setString(5,dm.getCertificateno());
            ps.setString(6,dm.getCertificatepath());
            ps.setString(7,dm.getReqEusername());
            ps.setString(8,dm.getStatus());
            ps.setInt(9, dm.getAadhar());
            
            return(ps.executeUpdate()>0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
       }

 public boolean ifSeekerInfo(String eusername,ServletContext context) {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select eusername from users where eusername=? and status='true'";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,eusername);
            rs=ps.executeQuery();
            if(rs.next())
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateSeeker(UserModel um, ServletContext context) {
        
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="update users set familyincome=?,category=?,status='true' where eusername=?";
            
            ps=con.prepareStatement(qr);
            ps.setInt(1,um.getIncome());
            ps.setString(2,um.getCategory());
            ps.setString(3,um.getEusername());
            
            if(ps.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
       
    
}
