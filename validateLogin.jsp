<%@ page import="java.sql.*" %>
<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "password");
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, user);
        ps.setString(2, pass);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            out.println("<h3>Welcome, " + user + "! Login Successful.</h3>");
        } else {
            out.println("<h3>Invalid Username or Password!</h3>");
        }
        
        con.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>

