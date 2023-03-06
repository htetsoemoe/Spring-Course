package demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            String name = req.getParameter("name");
            String hobby = req.getParameter("hobby");

            out.println("<html>");
            out.println("<head><title>Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello Greeting Servlet.</h1>");
            out.println("<p>Name : " + name + "</p>");
            out.println("<p>Hobby : " + hobby + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
