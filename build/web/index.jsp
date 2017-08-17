<%-- 
    Document   : index.jsp
    Created on : 16 Aug, 2017, 4:22:30 PM
    Author     : SarthakJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
        
<fieldset><legend>L O G - I N</legend>
            <form action="VerifyUser" method="post">
                <pre>
         USER-NAME <input type="text" name="euname"/><br>
         PASSWORD  <input type="password" name="pwd"/><br><br>
                    <input type="submit" value="LOG-IN">
                </pre>
            </form>
    </fieldset>
    <a href="UserRegister.jsp">Register Here</a>
        
        
    </body>
</html>
