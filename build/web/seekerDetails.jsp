<%-- 
    Document   : seekerDetails
    Created on : 17 Aug, 2017, 9:32:33 PM
    Author     : SarthakJ
--%>
<%@page import="model.UserModel"%>
<%
UserModel um=(UserModel)session.getAttribute("UserModel");
String euname=um.getEusername();
boolean flag=false;
int income=0;
String cat="";
if(um.getCategory()!=null){
cat=um.getCategory();
income=um.getIncome();
flag=true;
}

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            var flag="<%=flag%>";
            function setValues()
            {
                if(flag=="true")
                {
                    document.getElementById("inc").value=<%= income %>;
                    document.getElementById("cat").value="<%= cat %>";
                }
            }
        </script>
    </head>
    <body onload="setValues()">
        <h1><strong>Scholarship seeker Info</strong></h1>
        
        <pre>
            <form action="SaveSeekerInfo" method="post">
                Family-Income <input type="text" name="income" id="inc"/><br>
                Category      <select name="cat" id="cat"><option value="general">General</option><option value="minority">Minority</option><option value="sc/st">SC/ST</option><option value="obc">OBC</option></select><br>
                        <input type="submit" value="Submit"/>
</form>
        </pre>
    </body>
</html>
