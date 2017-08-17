/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserModel;

@WebServlet(name = "RegisterUser", urlPatterns = {"/RegisterUser"})
public class RegisterUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        ServletContext context=getServletContext();
            
        UserModel um= new UserModel();
        
        um.setAadhar(Integer.parseInt(request.getParameter("aadhar")));
        um.setAddress((String) request.getParameter("address"));
        um.setDob((String) request.getParameter("dob"));
        um.setCity((String) request.getParameter("city"));
        um.setState((String) request.getParameter("state"));
        um.setEusername((String) request.getParameter("username"));
        System.out.print((String) request.getParameter("username"));
        um.setFathername((String) request.getParameter("father"));
        um.setName((String) request.getParameter("name"));
        um.setEmail((String) request.getParameter("email"));
        um.setPassword((String) request.getParameter("password"));
        um.setAddress((String) request.getParameter("address"));
        um.setGender((String) request.getParameter("gender"));
        um.setContact(Integer.parseInt(request.getParameter("mobile")));
        UserDao ud=new UserDao();
        
        if(ud.insertUser(um, context))
        { 
            response.getWriter().println("inserted successfully <br> <a href=\"index.jsp\">home</a>");
        }
        
        else
        {
            response.getWriter().println("insertion failed<br> <a href=\"index.jsp\">home</a>");
        
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
