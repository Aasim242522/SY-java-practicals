<%@ page import="java.sql.*" %>
<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
    String email = request.getParameter("email");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "password");
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, password, email) VALUES(?, ?, ?)");
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.setString(3, email);
        
        int i = ps.executeUpdate();
        
        if (i > 0) {
            out.println("<h3>Registration Successful! <a href='display.jsp'>View Records</a></h3>");
        } else {
            out.println("<h3>Registration Failed!</h3>");
        }
        
        con.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>

