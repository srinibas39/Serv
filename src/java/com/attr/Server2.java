package com.attr;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Server2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Server2</title>");
            out.println("</head>");
            out.println("<body>");
            
            

            int sum = (int) request.getAttribute("sum");
            int num1 =Integer.parseInt(request.getParameter("number1"));
            int num2 =Integer.parseInt(request.getParameter("number2"));
            int mul = num1 * num2;
            String numStr = (String)request.getAttribute("numStr");
            
            
            out.println(numStr);

            out.println("<h1>MUL = ");
            out.println(mul);
            out.println("</h1>");
            out.println("<h1>SUM = ");
            out.println(sum);
            out.println("</h1>");
             out.println("hello");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
