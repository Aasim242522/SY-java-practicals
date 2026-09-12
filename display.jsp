
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head><title>User List</title></head>
<body>
    <h2>Registered Users</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "password");
                
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, username, email FROM users");
                
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("username") %></td>
            <td><%= rs.getString("email") %></td>
        </tr>
        <%
                }
                con.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>
