<%-- 
    Document   : TeamDB
    Created on : Nov 20, 2017, 8:40:34 AM
    Author     : koraniar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.unisports.entities.Team"%>
<%@page import="java.util.List"%>
<%@page import="com.unisports.bl.TeamBL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Table</title>
    </head>
    <body>
        <h1>The User Database Table</h1>

        <%
            TeamBL userService = new TeamBL();
            List<Team> teams = userService.GetAllTeams();
        %>

        <table BORDER="1">
            <tr>
                <th>ID</th>
                <th>Name</th>                
                <th>Description</th>
                <th>Logo</th>
                <th>Motto</th>
                <th>Sport Id</th>
                <th>Actions</th>
            </tr>
            <% for (Iterator<Team> i = teams.iterator(); i.hasNext();) {
                    Team item = i.next();%>
            <tr>
                <td> <%= item.getId()%></td>
                <td> <%= item.getName()%></td>                
                <td> <%= item.getDescription()%></td>
                <td> <%= item.getLogo()%></td>
                <td> <%= item.getMotto()%></td>
                <td> <%= item.getSportId()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
