/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PolicyDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PolicyModel;
import model.UserModel;

/**
 *
 * @author rohan
 */
public class AddNewPolicy extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            HttpSession session=request.getSession();
            ServletContext context=getServletContext();
            UserModel um=(UserModel)session.getAttribute("UserModel");
            PolicyModel pm=new PolicyModel();
            
            pm.setOid(Integer.parseInt(request.getParameter("orgName")));
            pm.setPolicytype(request.getParameter("policy"));
            pm.setRefid(request.getParameter("ref"));
            pm.setAccno(request.getParameter("account"));
            pm.setBankname(request.getParameter("bankname"));
            pm.setIfsc(request.getParameter("ifsc"));
            pm.setDateofpolicy(request.getParameter("startsfrom"));
            pm.setValidupto(request.getParameter("validupto"));
            pm.setAadhar(request.getParameter("aadhar"));
            pm.setEmpeusername(um.getEusername());
            
            PolicyDao pd=new PolicyDao();
            if(pd.savePolicy(pm,context))
            {
                out.println("<h1>Policy Saved Sucessfully</h1><br><a href=\"UserMenu.jsp\">Go To User Menu</a>");
            }
            else
            {
                out.println("<h1>Policy Not Saved Error Occured</h1><br><a href=\"UserMenu.jsp\">Go To User Menu</a>");
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
