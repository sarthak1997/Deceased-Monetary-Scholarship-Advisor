<%-- 
    Document   : scholarshipScheme
    Created on : 16 Aug, 2017, 4:42:28 PM
    Author     : SarthakJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
 function getXmlHttpRequestObject()
{
var xmlHttpReq;

if(window.XMLHttpRequest){
    request=new window.XMLHttpRequest();
}
else if(window.ActiveXObject){
    request=new window.ActiveXObject();
}
else{
    request=null;
}
return request;
}

function getOrg()
{   
    request=getXmlHttpRequestObject();
    request.onreadystatechange=setOrg;
    request.open("post","FetchOrg",true);
    request.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");
    var data="";
    request.send(data);
}

function setOrg()
{
    if(request.readyState===4 && request.status===200)
    {
        if(request.responseText.trim()=="false")
        {
            alert("You Are Not Authorized User...");
            window.location="UserMenu.jsp";
        }
        
        document.getElementById("orgList").innerHTML=request.responseText;
    }
}

        </script>
    </head>
    <body onload="getOrg()">
        <h1><strong>ADD SCHOLARSHIP SCHEME</strong></h1>
        <pre>
            <form action="AddScholarship" method="post">
                Choose Your Organizations <select id="orgList" name="oname"></select>
            <fieldset>
            <legend>General Details</legend>
            Name of Scheme  <input type="text" name="nos"/><br>
            Amount Provided <input type="text" name="amt"/><br>
            How To Apply    <input type="text" name="howta"/><br>
            Deadline        <input type="text" name="dline"/><br>
            </fieldset>
            <fieldset>
            <legend>Eligibility Criteria</legend>
            Income     - <input type="text" placeholder="LESS THAN............." name="income"/><br>
            Category   - <select name="cat"><option name="cat" value="general">General</option><option name="cat" value="minority">Minority</option><option name="cat" value="sc/st">SC/ST</option><option name="cat" value="obc">OBC</option></select><br>
            Percentage - <input type="text" name="perc" placeholder="Above........."/><br>
            Class -ABOVE <select name="classab"><option name="classab" value="any">Everyone</option><option name="classab" value="1st">1st</option><option name="classab" value="2nd">2nd</option><option name="classab" value="3rd">3rd</option><option name="classab" value="4th">4th</option><option name="classab" value="5th">5th</option><option name="classab" value="6th">6th</option><option name="classab" value="7th">7th</option><option name="classab" value="8th">8th</option><option name="classab" value="9th">9th</option><option name="classab" value="10th">10th</option><option name="classab" value="11th">11th</option><option name="classab" value="12th">12th</option><option name="classab" value="Graduate">GRADUATE</option><option name="classab" value="Post-Graduate">POST-GRADUATE</option></select> UPTO <select name="classup"><option name="classup" value="any">Everyone</option><option name="classup" value="1st">1st</option><option name="classup" value="2nd">2nd</option><option name="classup" value="3rd">3rd</option><option name="classup" value="4th">4th</option><option name="classup" value="5th">5th</option><option name="classup" value="6th">6th</option><option name="classup" value="7th">7th</option><option name="classup" value="8th">8th</option><option name="classup" value="9th">9th</option><option name="classup" value="10th">10th</option><option name="classup" value="11th">11th</option><option name="classup" value="12th">12th</option><option name="classup" value="Graduate">GRADUATE</option><option name="classup" value="Post-Graduate">POST-GRADUATE</option></select><br>
            </fieldset>
            <fieldset>
            <legend>Other Details</legend>
            <textarea rows="5" cols="30" placeholder="Enter additional details here" name="otherd"></textarea>
            </fieldset>
                    <input type="submit" value="ADD"/>
            </form>
        </pre>
    </body>
</html>
