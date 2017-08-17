/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmpDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmpModel;
import model.UserModel;

/**
 *
 * @author SarthakJ
 */
public class SaveEmp extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int oid=Integer.parseInt(request.getParameter("oname"));
        String desg=request.getParameter("desg");
        
        HttpSession session=request.getSession();
        ServletContext context=getServletContext();
        
        UserModel um=(UserModel)session.getAttribute("UserModel");
        
        String euname=um.getEusername();
        
        EmpModel em=new EmpModel();
        em.setDesignation(desg);
        em.setOid(oid);
        em.seteUserName(euname);
        
        EmpDao ed=new EmpDao();
        
        if(ed.addEmp(em,context))
        { 
            response.getWriter().println("<h1>Your Request Is Under Verification</h1> <br><a href=\"UserMenu.jsp\">HOME</a>");
        }
        else
        {
        response.getWriter().println("Something Went Wrong...!!<br><a href=\"UserMenu.jsp\">HOME</a>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
