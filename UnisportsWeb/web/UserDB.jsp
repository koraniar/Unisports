<%-- 
    Document   : UserDB
    Created on : Nov 19, 2017, 10:18:23 PM
    Author     : koraniar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.unisports.entities.User"%>
<%@page import="java.util.List"%>
<%@page import="com.unisports.bl.UserBL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Table</title>
    </head>
    <body>
        <h1>The User Database Table</h1>

        <%
            UserBL userService = new UserBL();
            List<User> users = userService.getAllUsers();
        %>

        <table BORDER="1">
            <tr>
                <th>ID</th>
                <th>Name</th>                
                <th>Last Name</th>
                <th>Born Date</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Actions</th>
            </tr>
            <% for (Iterator<User> i = users.iterator(); i.hasNext();) {
                    User item = i.next();%>
            <tr>
                <td> <%= item.getId()%></td>
                <td> <%= item.getName()%></td>                
                <td> <%= item.getLastName()%></td>
                <td> <%= item.getBornDate()%></td>
                <td> <%= item.getEmail()%></td>
                <td> <%= item.getPassword()%></td>
                <td> <%= item.getAddress()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
