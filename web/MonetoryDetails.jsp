<%-- 
    Document   : MonetoryDetails
    Created on : 17 Aug, 2017, 8:42:17 PM
    Author     : Rohit
--%>
<%@page import="model.PolicyModel"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList <PolicyModel> MonetoryInfo=(ArrayList)session.getAttribute("MonetoryInfo");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monetory Details</title>
    </head>
    <body>
        <h1>MONETORY DETAILS</h1>
        <%if (MonetoryInfo!=null)
                    {
        %>
        <table border="1">
            <tr>
                <th>S.No</th>
                <th>Reference Id</th>
                <th>Account No</th>
                <th>IFSC Code</th>
                <th>Bank Name</th>
                <th>Organization Name</th>
                <th>Policy Type</th>
                <th>Date Of Policy</th>
                <th>Valid Upto</th>
                
              </tr>
              
              <% 
                    int i=0;
                    for(PolicyModel pm:MonetoryInfo)
                    {
              %>
                            <tr>
                                <td><%=i+1%></td>
                                <td><%=pm.getRefid() %></td>
                                <td><%=pm.getAccno() %></td>
                                <td><%=pm.getIfsc() %></td>
                                <td><%=pm.getBankname() %></td>
                                <td><%=pm.getOrgname() %></td>
                                <td><%=pm.getPolicytype() %></td>
                                <td><%=pm.getDateofpolicy() %></td>
                                <td><%=pm.getValidupto() %></td>
                                
                            </tr>
              <%
                    i++;}
                    }
        else
        {
            %><h1>NO DETAILS FOUND</h1><%
        }
              %>
        </table>
        <a href="UserMenu.jsp">User Menu</a>
    </body>
</html>
