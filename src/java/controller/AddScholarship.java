/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ScholarshipDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SchSchemeModel;

/**
 *
 * @author SarthakJ
 */
public class AddScholarship extends HttpServlet {

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
        
        PrintWriter out=response.getWriter();
        ServletContext context=getServletContext();
        
        int oid=Integer.parseInt(request.getParameter("oname"));
        String nos=request.getParameter("nos");
        int amt=(Integer.parseInt(request.getParameter("amt")));
        String howta=request.getParameter("howta");
        String dline=request.getParameter("dline");
        int income=(Integer.parseInt(request.getParameter("income")));
        String cat=request.getParameter("cat");
        float perc=(Float.parseFloat(request.getParameter("perc")));
        String above=request.getParameter("classab");
        String upto=request.getParameter("classup");
        String otherd=request.getParameter("otherd");
        
        SchSchemeModel sch=new SchSchemeModel();
        sch.setAbove(above);
        sch.setAmt(amt);
        sch.setCat(cat);
        sch.setDeadLine(dline);
        sch.setIncome(income);
        sch.setOid(oid);
        sch.setNameSch(nos);
        sch.setHowA(howta);
        sch.setOtherD(otherd);
        sch.setPercent(perc);
        sch.setUpto(upto);
        
        ScholarshipDao sd=new ScholarshipDao();
        
        if(sd.addScheme(sch,context))
        {
            out.println("<h1><strong>Scheme Added</strong></h1><br><br><a href=\"LoadGiverSchemes\">Go Back To See Changes</a>");
        }
        else
        {
            
            
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
