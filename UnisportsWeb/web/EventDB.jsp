<%@page import="java.util.Iterator"%>
<%@page import="com.unisports.entities.Event"%>
<%@page import="java.util.List"%>
<%@page import="com.unisports.bl.EventBL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Table</title>
    </head>
    <body>
        <h1>The Event Database Table</h1>

        <%
            EventBL userService = new EventBL();
            List<Event> events = userService.GetAllRecentEvents();
        %>

        <table BORDER="1">
            <tr>
                <th>ID</th>
                <th>Created Date</th>                
                <th>Date</th>
                <th>State</th>
                <th>Description</th>
                <th>Sport Id</th>
                <th>Actions</th>
            </tr>
            <% for (Iterator<Event> i = events.iterator(); i.hasNext();) {
                    Event item = i.next();%>
            <tr>
                <td> <%= item.getId()%></td>
                <td> <%= item.getCreatedDate()%></td>                
                <td> <%= item.getDate()%></td>
                <td> <%= item.getState()%></td>
                <td> <%= item.getDescription()%></td>
                <td> <%= item.getSportId()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
