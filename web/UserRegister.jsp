<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Register</title>
    </head>
    <body> 
        <fieldset><legend>Sign-Up</legend>
        <FORM action="RegisterUser" method="post">
            <pre>
            
            USER NAME       <INPUT TYPE="TEXT" name="username" onchange="checkUserName()" id="uname"/>
            AADHAR NO       <INPUT TYPE="number" name="aadhar"/>
            NAME            <INPUT TYPE="TEXT" name="name"/>
            DOB             <INPUT TYPE="date" name="dob"/>
            MOBILE          <INPUT TYPE="TEXT" name="mobile"/>
            EMAIL-ID        <INPUT type="email" name="email"/>
            FATHER NAME     <INPUT type="text" name="father"/>
            GENDER          <INPUT type="radio" name="gender" value="male"/> Male
                            <INPUT type="radio" name="gender" value="female"/> Female
            PASSWORD       <INPUT type="password" name="password"/>
            STATE           <INPUT type="text" name="state"/>
            CITY            <INPUT type="text" name="city"/>
            ADDRESS         <INPUT type="text" name="address"/>
                      <INPUT TYPE="SUBMIT" value="REGISTER"/>
            </pre>   
        </form>
        </fieldset>
        <br>
            <A HREF="index.jsp">HOME</A>
    </body>
</html>
