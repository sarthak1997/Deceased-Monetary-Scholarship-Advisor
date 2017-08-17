/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AcademicsDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HigherAcademics;
import model.SchoolAcademic;
import model.UserModel;

/**
 *
 * @author SarthakJ
 */
public class UpdateAcademics extends HttpServlet {

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
            
            ServletContext context=getServletContext();
            HttpSession session=request.getSession();
            
            String actype=request.getParameter("actype");
            UserModel um=(UserModel)session.getAttribute("UserModel");
            AcademicsDao ad=new AcademicsDao();
            
            if(actype.equals("low"))
            {
                SchoolAcademic sac=new SchoolAcademic();
                sac.setSchool(request.getParameter("school"));
                sac.setClassSch((request.getParameter("classSch1")));
                sac.setPercentage(Float.parseFloat(request.getParameter("perc")));
                sac.setBoard(request.getParameter("board"));
                sac.setEusername(um.getEusername());
                
                if(ad.addLAcademics(sac,context))
                {
                    out.print("<h1><strong>SUCCESS</strong></h1><br><a href=\"CheckStatus\">GO BACK</a>");
                }
            }
            else if(actype.equals("medium"))
            {
                SchoolAcademic sac=new SchoolAcademic();
                sac.setSchool(request.getParameter("school"));
                System.out.println(request.getParameter("classSch2")+"--------------------");
                sac.setClassSch((request.getParameter("classSch2")));
                sac.setPercentage(Float.parseFloat(request.getParameter("perc")));
                sac.setBoard(request.getParameter("board"));
                sac.setEusername(um.getEusername());
                if(ad.addMAcademics(sac,context))
                {
                    out.print("<h1><strong>SUCCESS</strong></h1><br><a href=\"CheckStatus\">GO BACK</a>");
                }
            }
            else if(actype.equals("high"))
            {
                HigherAcademics hac=new HigherAcademics();
                hac.setCollege(request.getParameter("college"));
                hac.setCoursename(request.getParameter("course"));
                hac.setSgpa(Float.parseFloat(request.getParameter("sgpa")));
                hac.setCgpa(Float.parseFloat(request.getParameter("cgpa")));
                hac.setEusername(um.getEusername());
                if(ad.addHAcademics(hac,context))
                {
                    out.print("<h1><strong>SUCCESS</strong></h1><br><a href=\"CheckStatus\">GO BACK</a>");
                }
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
