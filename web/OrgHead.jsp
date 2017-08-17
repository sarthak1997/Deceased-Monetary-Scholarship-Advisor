<%-- 
    Document   : OrgHead
    Created on : 17 Aug, 2017, 8:41:47 PM
    Author     : rohan
--%>
<%@page import="model.EmpUserModel"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<EmpUserModel> aleum=(ArrayList<EmpUserModel>)session.getAttribute("PendingRequests");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome Organization Head</h1><br>
        
         <fieldset>
            <legend>
                VERIFY REQUESTS
            </legend>
            <%if(aleum!=null){%>
            <table border="1">
                <tr>
                    <td>NAME</td>
                    <td>ORG-NAME</td>
                    <td>DESIGNATION</td>
                    <td>CONTACT NO</td>
                    <td>E-MAIL</td>
                    <td>VERIFICATION RESULT</td>
                </tr>
            <%int i=0;for(EmpUserModel eum:aleum){%>
            <tr>
                    <td><%= eum.getName() %></td>
                    <td><%= eum.getOrgname() %></td>
                    <td><%= eum.getDesignation() %></td>
                    <td><%= eum.getContactno() %></td>
                    <td><%= eum.getEmail() %></td>
                    <td><button onclick="accept('<%=i%>')">ACCEPT</button><button onclick="reject('<%=i %>')">REJECT</button></td>
            </tr>
            <%i++;}}
            else
            {%>
            <h1>NO PENDING REQUESTS</h1>     
           <% }%>
        </fieldset>
        <script>
            
            function accept(i)
            {
                window.location="OrgHeadDecision?dec=accept&index="+i;
            }
            
            function reject(i)
            {
                window.location="OrgHeadDecision?dec=reject&index="+i;
            }
        </script>
    </body>
</html>
