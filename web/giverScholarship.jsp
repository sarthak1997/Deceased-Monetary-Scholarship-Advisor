<%-- 
    Document   : giverScholarship
    Created on : 16 Aug, 2017, 5:24:45 PM
    Author     : SarthakJ
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SchSchemeModel"%>
<%
ArrayList<SchSchemeModel> alsch=(ArrayList<SchSchemeModel>)session.getAttribute("FetchedSch");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="scholarshipScheme.jsp">Add Scholarship Schemes</a>
        
        <h1><strong>Your Scholarship Schemes</strong></h1>
        
        <%
if(alsch!=null){
        for(SchSchemeModel sch : alsch){
        %>
        <fieldset>
            <legend><h2><strong><%= sch.getNameSch().toUpperCase() %></strong></h2></legend>
            <br>
            <fieldset>
                <legend>General Details</legend>
                <strong>Amount   - </strong> <%= sch.getAmt() %><br>
                <strong>Deadline - </strong> <%= sch.getDeadLine() %><br>
            </fieldset>
            
            
            <fieldset>
                <legend>HOW TO APPLY?</legend>
                <p><%=sch.getHowA() %></p>
            </fieldset>
            <fieldset>
                <legend>Eligibility Criteria</legend>
                <strong>Income     - </strong> <%=sch.getIncome() %><br>
                <strong>Category   - </strong> <%=sch.getCat() %><br>
                <strong>Percentage - </strong> <%=sch.getPercent() %>%<br>
                <strong>Class      - </strong> <br> Above :<%= sch.getAbove() %> and Upto :<%= sch.getUpto() %>
            </fieldset>
            <fieldset>
                <legend>Other Details</legend>
                <p><%=sch.getOtherD() %></p>
            </fieldset>
        </fieldset>
            <%}}%>
    </body>
</html>
