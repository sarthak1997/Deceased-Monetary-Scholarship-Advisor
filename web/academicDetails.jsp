<%-- 
    Document   : academicDetails
    Created on : 17 Aug, 2017, 9:51:22 PM
    Author     : SarthakJ
--%>

<%
String level=request.getParameter("level");
String cl=request.getParameter("cl");
String cl1="1st to 10th",cl2="11th & 12th",cl3="Higher Studies";
if(level.equals("l"))
{
    cl1=cl;
    cl2="11th & 12th";
    cl3="Higher Details";
}
else if(level.equals("m"))
{
    cl1="1st to 10th";
    cl2=cl;
    cl3="Higher Details";
}
else if(level.equals("l"))
{
    cl1="1st to 10th";
    cl2="11th & 12th";
    cl3="Higher Details";
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            var level="<%=level%>";
            var cl="<%=cl%>";
            console.log(level+"-------"+cl);
            
            function openField()
            {
                if(level=="l")
                {
                    console.log("hey");
                    document.getElementById("med").disabled="true";
                    document.getElementById("high").disabled="true";
                    
                    
                }
                if(level=="m")
                {
                    document.getElementById("low").disabled="true";
                    document.getElementById("high").disabled="true";
                    
                }
                if(level=="h")
                {
                    document.getElementById("low").disabled="true";
                    document.getElementById("med").disabled="true";
                }
            }
        </script>
    </head>
    <body onload="openField()">
        <fieldset id="low">
            <legend><h2><strong><%=cl1%></strong></h2></legend>
            
            <pre>
<form action="UpdateAcademics?actype=low" method="post">
                SCHOOL     <input type="text" name="school"/><br>
                CLASS      <select name="classSch1" id="cl1"><option name="classab" value="1">1st</option><option name="classab" value="2">2nd</option><option name="classab" value="3">3rd</option><option name="classab" value="4">4th</option><option name="classab" value="5">5th</option><option name="classab" value="6">6th</option><option name="classab" value="7">7th</option><option name="classab" value="8">8th</option><option name="classab" value="9">9th</option><option name="classab" value="10">10th</option></select><br>
                PERCENTAGE <input type="text" name="perc"/><br>
                BOARD      <select name="board"><option value="rjboard">Rajasthan Board</option><option value="cbse">C.B.S.E</option><option value="icse">I.C.S.E</option></select><br>
                <br>                             <input type="submit" value="ADD"/>
</form>
            </pre>
        </fieldset>
        <fieldset id="med">
            <legend><h2><strong><%=cl2%></strong></h2></legend>
            
            <pre>
<form action="UpdateAcademics?actype=medium" method="post">
                SCHOOL     <input type="text" name="school"/><br>
                CLASS      <select name="classSch2" id="cl2"><option name="classab" value="11">11th</option><option name="classab" value="12">12th</option></select><br>
                PERCENTAGE <input type="text" name="perc"/><br>
                BOARD      <select name="board"><option value="rjboard">Rajasthan Board</option><option value="cbse">C.B.S.E</option><option value="icse">I.C.S.E</option></select><br>
                <br>                             <input type="submit" value="ADD"/>
</form>
            </pre>
        </fieldset>
        <fieldset id="high">
            <legend><h2><strong><%= cl3 %></strong></h2></legend>
            
            <pre>
<form action="UpdateAcademics?actype=high" method="post">
                DEGREE     <input type="text" name="degree"/><br>
                COURSE     <input type="text" name="course"/><br>
                UNIVERSITY <input type="text" name="university"/><br>
                S.G.P.A    <input type="text" name="sgpa" placeholder="CURRENT SEMESTER"/><br>
                C.G.P.A    <input type="text" name="cgpa"/><br>
                <br>                             <input type="submit" value="ADD"/>
</form>
            </pre>
        </fieldset>
    </body>
<!--    <script>
        openField();
    </script>-->
</html>
