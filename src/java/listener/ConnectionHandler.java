/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author rohan
 */
public class ConnectionHandler implements ServletContextListener {

    private Connection con;
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        connection(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void connection(ServletContextEvent sce){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println("loaded");
        try {
          con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hackathon","root","root");
           //con=DriverManager.getConnection("jdbc:mysql://64.62.211.131:3306/korero_admindb","korero_admin","123456789");
            System.out.println("connected...");
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
	
        sce.getServletContext().setAttribute("datacon",con);
        
       
    }
}
