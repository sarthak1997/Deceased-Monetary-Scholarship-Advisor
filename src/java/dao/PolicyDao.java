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
import model.PolicyModel;
import model.UserModel;

/**
 *
 * @author Rohit
 */
public class PolicyDao {
     PreparedStatement ps,ps1;
    ResultSet rs,rs1;
    Connection con;

    public ArrayList<PolicyModel> showmonetory(PolicyModel pm, HttpSession session, ServletContext context)
       {   
         try {
             con=(Connection)context.getAttribute("datacon");
             ArrayList <PolicyModel> alpm = new ArrayList();
             UserModel um=(UserModel) session.getAttribute("UserModel");
             String qr="select refid,accno,ifsc,bankname,policytype,validupto,orgname,dateofpolicy from policyinfo inner join organizations where custeusername=? and policyinfo.oid=organizations.oid";
             ps=con.prepareStatement(qr);
             ps.setString(1,um.getEusername());
             rs=ps.executeQuery();
             
             while(rs.next())
             {
                 pm=new PolicyModel();
                 pm.setRefid(rs.getString(1));
                 pm.setAccno(rs.getString(2));
                 pm.setIfsc(rs.getString(3));
                 pm.setBankname(rs.getString(4));
                 pm.setPolicytype(rs.getString(5));
                 pm.setValidupto(rs.getString(6));
                 pm.setOrgname(rs.getString(7));
                 pm.setDateofpolicy(rs.getString(8));
                 alpm.add(pm);
             }
             return alpm;
         } catch (SQLException ex) {
             Logger.getLogger(PolicyDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        
           
    
       return null; }

    public boolean savePolicy(PolicyModel pm, ServletContext context) {
         try {
             //To change body of generated methods, choose Tools | Templates.
             con=(Connection)context.getAttribute("datacon");
             String qr1="select eusername from users where aadhar=?";
             ps=con.prepareStatement(qr1);
             ps.setString(1,pm.getAadhar());
             rs=ps.executeQuery();
             String euname=null;
             if(rs.next())
             {
                 euname=rs.getString(1);
                  String qr="insert into policyinfo(oid,empeusername,refid,dateofpolicy,validupto,bankname,ifsc,accno,custeusername,policytype) values(?,?,?,?,?,?,?,?,?,?)";
             ps=con.prepareStatement(qr);
             ps.setInt(1,pm.getOid());
             ps.setString(2,pm.getEmpeusername());
             ps.setString(3,pm.getRefid());
             ps.setString(4,pm.getDateofpolicy());
             ps.setString(5,pm.getValidupto());
             ps.setString(6,pm.getBankname());
             ps.setString(7,pm.getIfsc());
             ps.setString(8,pm.getAccno());
             ps.setString(9,euname);
             ps.setString(10,pm.getPolicytype());
      
             
             return(ps.executeUpdate()>0);
             }
             
            
         } catch (SQLException ex) {
             Logger.getLogger(PolicyDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }

    public void getDeathRequests(String empeusername, ServletContext context) {
         try {
             //To change body of generated methods, choose Tools | Templates.
             
             con=(Connection)context.getAttribute("datacon");
             String qr="select users.aadhar,users.name,place,cause,certificateno,certificatepath,reqEusername from deathinfo inner join users where users.eusername=deathinfo.eusername and deathinfo.eusername in (select custeusername from policyinfo where empeusername=?)";
             String qr1="";
             ps=con.prepareStatement(qr);
             ps.setString(1,empeusername);
             rs=ps.executeQuery();
             DeathModel dm=null;
             while(rs.next())
             {
                 dm.setAadhar(rs.getInt(1));
                 dm.setName(rs.getString(2));
                 dm.setPlace(rs.getString(3));
                 dm.setCause(rs.getString(4));
                 dm.setCertificateno(rs.getString(5));
                 dm.setCertificatepath(rs.getString(6));
                 dm.setReqEusername(rs.getString(7));
                
             }
         } catch (SQLException ex) {
             Logger.getLogger(PolicyDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
}
