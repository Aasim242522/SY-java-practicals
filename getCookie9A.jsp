<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = null;
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("userCookie".equals(cookie.getName())) {
                username = cookie.getValue();
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Get Cookie</title>
</head>
<body>
    <h2>Retrieved Cookie Value</h2>
    <% if (username != null) { %>
        <p>Welcome back, <strong><%= username %></strong>!</p>
    <% } else { %>
        <p>No user cookie found.</p>
    <% } %>
    <a href="index_a.html">Back to Form</a>
</body>
</html>
