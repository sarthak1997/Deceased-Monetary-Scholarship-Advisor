/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DeathModel;
import model.UserModel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Rohit
 */
public class ChangeLife extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          ServletContext context=getServletContext();
           HttpSession session=request.getSession();
           
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            DeathModel dm=new DeathModel();
                            List<FileItem> item;
                item = upload.parseRequest(request);
                                for(FileItem items:item )
                {
                    String s=items.getFieldName();
                    
                    if(s.equals("certi"))
                    {
                        int size;
                        size = (int)items.getSize();
                        byte b[]=new byte[size];
                        try (InputStream is = items.getInputStream()) {
                            is.read(b);
                    }
                        
                         String fname=items.getName();
                       String path=getServletConfig().getServletContext().getRealPath("/")+"Certificates\\"+fname;
                        try (FileOutputStream fos = new FileOutputStream(path)) {
                            fos.write(b);
                            dm.setCertificatepath(path);
                        }
                      
                }
                    else if(s.equals("deathno"))
                    {
                        dm.setCertificateno(items.getString());
                    }
                    else if(s.equals("deathplace"))
                    {
                        dm.setPlace(items.getString());
                    }
                    else if(s.equals("deathdate"))
                    {
                        dm.setDeathdate(items.getString());
                    }
                    
                    else if(s.equals("aadhar"))
                    {
                        dm.setAadhar(Integer.parseInt(items.getString()));
                    }
                    
                    else if(s.equals("cause"))
                    {
                        dm.setCause(items.getString());
                    }
                    
                    else if(s.equals("eusername"))
                    {
                        dm.setEusername(items.getString());
                    }
                    }
                    UserModel um=(UserModel) session.getAttribute("UserModel");
                   
                    dm.setReqEusername(um.getEusername());
                    dm.setStatus("dead");
                    UserDao ud=new UserDao();
                    
                    if(ud.insertDeathInfo(dm,context,session))
                    {
                        out.println("verification under process");
                    }
                    else
                    {
                        out.println("unsuccessful");
                    }
                                

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(ChangeLife.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(ChangeLife.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
