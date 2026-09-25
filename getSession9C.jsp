<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Retrieve object from session and cast to String
    String username = (String) session.getAttribute("sessionUser");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Get Session Value</title>
</head>
<body>
    <h2>Retrieved Session Value</h2>
    <% if (username != null) { %>
        <p>Active Session User: <strong><%= username %></strong></p>
    <% } else { %>
        <p>No user session found or session has expired.</p>
    <% } %>
    <a href="index_c.html">Back to Form</a>
</body>
</html>
