<%-- 
    Document   : changelifestatus
    Created on : 17 Aug, 2017, 7:34:08 AM
    Author     : Rohit
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserModel"%>
<%
   int id=Integer.parseInt(request.getParameter("id"));
   ArrayList <UserModel> FamilyInfo=(ArrayList)session.getAttribute("FamilyInfo");
   UserModel um=new UserModel();
   if(FamilyInfo!=null)
   {
       um=FamilyInfo.get(id);
   }
   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Life Status</title>
    </head>
    <body>
         <fieldset><legend><h1>Life Status</h1></legend>
             <FORM action="ChangeLife" method="post" enctype="multipart/form-data">
            <pre>
            NAME                   <INPUT TYPE="TEXT" name="name" value="<%=um.getName()%>"/>
            AADHAR NO              <INPUT TYPE="number" name="aadhar" value="<%=um.getAadhar() %>" />
            EMITRA ID               <input type="text" name="eusername" value="<%=um.getEusername() %>"
            DOB                    <INPUT TYPE="date" name="dob" value="<%=um.getDob()%>"/>
            DEATH DATE             <INPUT TYPE="date" name="deathdate" />
            DEATH PLACE            <INPUT type="text" name="deathplace" />
            CAUSE                  
                                   <textarea name="cause" rows="5" cols="22"></textarea>
            DEATH CERTIFICATE NO.  <INPUT TYPE="text" name="deathno"/>
            UPLOAD CERTIFICATE     <INPUT TYPE="file" name="certi"/>

                            <INPUT TYPE="SUBMIT" value="CHANGE STATUS"/>
            </pre>   
        </form>
        </fieldset>
        <br>
            <A HREF="index.jsp">HOME</A>
    
    </body>
</html>
