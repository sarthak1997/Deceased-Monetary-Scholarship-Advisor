/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrgDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.Organization;
import model.OrganizationModel;
import model.UserModel;

/**
 *
 * @author rohan
 */
public class SaveOrganization extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
        
         HttpSession session=request.getSession();
         ServletContext context=getServletContext();
         
         UserModel um=(UserModel)session.getAttribute("UserModel");
         OrganizationModel om=new OrganizationModel();
         om.setOrgName(request.getParameter("oname"));
         om.setOrgType(request.getParameter("otype"));
         om.setEmail(request.getParameter("email"));
         om.setContact(request.getParameter("contact"));
         om.setAddress(request.getParameter("address"));
         om.setCity(request.getParameter("city"));
         om.setState(request.getParameter("state"));
         om.setEmpNo(Integer.parseInt(request.getParameter("noe")));
         om.setOwUName(um.getEusername());
         
         OrgDao od=new OrgDao();
         if(od.insertOrganization(om, context))
         {
             out.println("Organization Added Successfully...<BR><a href=\"UserMenu.jsp\">USER MENU</a>");
         }
         else
         {
             out.println("Organization Not Added...!! <br><a href=\"\">Click Here To Add Again</a>");
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
