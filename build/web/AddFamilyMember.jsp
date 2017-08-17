<%-- 
    Document   : AddFamilyMember
    Created on : 17 Aug, 2017, 7:51:11 AM
    Author     : Rohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Family Member</title>
    </head>
    <body>
          <fieldset><legend><h1>ADD MEMBER</h1></legend>
        <FORM action="AddFamilyMember" method="post">
            <pre>
            
            NAME                <INPUT TYPE="TEXT" name="name"/>
            AADHAR NO           <INPUT TYPE="number" name="aadhar"/>
            E-MITRA USER NAME   <INPUT TYPE="text" name="eusername"/>
            DOB                 <INPUT TYPE="date" name="dob"/>

                           <INPUT TYPE="SUBMIT" value="ADD MEMBER"/>
            </pre>   
        </form>
        </fieldset>
        <br>
            <A HREF="index.jsp">HOME</A>
    </body>
</html>
