<%-- 
    Document   : empRegister
    Created on : 17 Aug, 2017, 11:49:22 AM
    Author     : SarthakJ
--%>


<%@page import="model.OrganizationModel"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<OrganizationModel> alstr=(ArrayList<OrganizationModel>)session.getAttribute("OrgList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><strong>Employee Register</strong></h1>
        
        <pre>
            <form action="SaveEmp" method="post">
                Organization Name <select name="oname"><%if(alstr!=null){ int i=0;for(OrganizationModel oname : alstr){%><option value="<%=oname.getOid()%>"><%=oname.getOrgName() %></option><%i++;}}%></select><br>
                Designation       <input type="text" name="desg"/><br>
                    <input type="submit" value="REGISTER-ME"/>
            </form>
        </pre>
    </body>
</html>
