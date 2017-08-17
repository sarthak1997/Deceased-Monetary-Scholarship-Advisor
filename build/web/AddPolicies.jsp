<%-- 
    Document   : AddPolicies
    Created on : 16 Aug, 2017, 5:00:21 PM
    Author     : rohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>korero</title>
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
        console.log(request.responseText);
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
        
        <fieldset>
        <legend>ADD NEW POLICY</legend>
        <form action="AddNewPolicy" method="post">
            <pre>
            Organization    <select id="orgList" name="orgName">
            </select><br>
            Policy          <select name="policy">
                <option value="fixed deposit">Fixed Deposit</option>
                <option value="mutual funds">Mutual Funds</option>
                <option value="accounts">Accounts</option>
                <option value="insurance">Insurance</option>
                <option value="loan">Loan</option>
            </select><br>
            Aadhar No.      <input type="text" name="aadhar"/><br>
            Reference Id    <input type="text" name="ref"/><br>
            Account No.     <input type="text" name="account"/><br>
            Bank Name       <input type="text" name="bankname"/><br>
            IFSC Code       <input type="text" name="ifsc"/><br>
            Starts From     <input type="date" name="startsfrom"/><br>
            Valid Upto      <input type="date" name="validupto"/><br>

            <input type="submit" value="ADD POLICY"/>
            </pre>
        </form>
        </fieldset>
        
    </body>
</html>
