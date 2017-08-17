<%-- 
    Document   : orgRegister
    Created on : 16 Aug, 2017, 4:27:14 PM
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
        <fieldset>
            <legend><strong>Register Your Organization</strong></legend>
        
        
            <form action="SaveOrganization" method="post">
                <pre>
            Organization Name <input type="text" name="oname"><br>
            Organization Type <select name="otype"><option value="0"></option><option value="Government">Government</option><option value="Semi-Government">Semi-Government</option><option value="Private">Private</option></select><br>
            E-MAIL ID         <input type="text" name="email"/><br>
            Contact-No.       <input type="text" name="contact"/><br>
            Address           <input type="text" name="address"/><br>
            City              <input type="text" name="city"/><br>
            State             <input type="text" name="state"/><br>
            No. Of Employees  <input type="number" name="noe"/><br>  
                    <input type="submit" value="REGISTER ORGANIZATION"/>
                    
                </pre>
            </form>
       </fieldset>
    </body>
</html>
