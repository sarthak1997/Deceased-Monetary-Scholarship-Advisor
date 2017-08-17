<%-- 
    Document   : Family
    Created on : 17 Aug, 2017, 1:37:27 PM
    Author     : Rohit
--%>
<%@page import="model.UserModel"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList <UserModel> FamilyInfo=(ArrayList<UserModel>)session.getAttribute("FamilyInfo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>FAMILY DETAILS</legend>
        <%
        if(FamilyInfo!=null){
        %>
        <table border="1">
           
           <tr>
                <th>S.NO</th>
                <th>Aadhar No</th>
                <th>Name</th>
                <th>Dob</th>
                
            </tr>
        <% 
            int i=0;
        
            for(UserModel um: FamilyInfo)
            {
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=um.getAadhar()%></td>
            <td><%=um.getName()%></td>
            <td><%=um.getDob()%></td>
            <td><button onclick="change(<%=i%>)">Change Life Status</button></td>  
        </tr>
        <%
           i++; }
            }
        else
        {
            %>
            <h1>NO DETAILS FOUND</h1>
            <%
        }
        %>
        </table>
        </fieldset><BR><BR><BR>
        <button onclick="addFamily()"> ADD FAMILY MEMBER</button><br><br>
    </body>
    
    <script>
        function addFamily()
        {
            window.location="AddFamilyMember.jsp";
        }
        function change(i)
        {
            
            window.location="ChangeLifeStatus.jsp?id="+i;
        }
    </script>
</html>
