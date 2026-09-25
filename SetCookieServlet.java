package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String userName = request.getParameter("username");
        
        // Create cookie and set 24-hour expiry
        Cookie userCookie = new Cookie("username", userName);
        userCookie.setMaxAge(24 * 60 * 60); 
        
        response.addCookie(userCookie);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Cookie saved successfully for: " + userName + "</h3>");
        out.println("<a href='GetCookieServlet'>Click here to retrieve cookie</a>");
        out.println("</body></html>");
    }
}