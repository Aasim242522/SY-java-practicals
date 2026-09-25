package practical11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        Cookie[] cookies = request.getCookies();
        boolean found = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    out.println("<h3>Cookie Value Found: " + c.getValue() + "</h3>");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            out.println("<h3>No 'username' cookie found!</h3>");
        }
        
        out.println("</body></html>");
    }
}