<%-- 
    Document   : index
    Created on : Nov 19, 2017, 9:52:20 PM
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
        <title>Azure database</title>
    </head>
    <body>
        <h1>Azure Database</h1>


        <form action = "UserDB.jsp">
            <input type="submit" value="Go to User DB">
        </form>
        <form action = "EventDB.jsp">
            <input type="submit" value="Go to Event DB">
        </form>
        <form action = "TeamDB.jsp">
            <input type="submit" value="Go to Team DB">
        </form>
    </body>
</html>
