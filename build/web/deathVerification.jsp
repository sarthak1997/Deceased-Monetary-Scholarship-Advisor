<%-- 
    Document   : deathVerification
    Created on : 16 Aug, 2017, 5:50:49 PM
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
        <h1><strong>Verify Below Requests</strong></h1>
        
        <table border="1">
            <thead>
            <th> S.NO </th>
            <th> Aadhar No. </th>
            <th> Name </th>
            <th> Death Place </th>
            <th> Cause </th>
            <th> Certificate No. </th>
            <th> View Death Certificate </th>
            <th> Name of the Requester </th>
            <th> Accept </th>
            <th> Reject </th>
            </thead>
            <tbody>
                <tr>
                    <td>1.</td>
                    <td>101010101</td>
                    <td>Test</td>
                    <td>Test</td>
                    <td>Test</td>
                    <td>Test</td>
                    <td><a href="">Download Here</a></td>
                    <td>Test</td>
                    <td><button name="acc" class="acc">Accept</button></td>
                    <td><button name="rej" class="rej">Reject</button></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
