package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Welcome to Form Response</h1>");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String terms = req.getParameter("terms");
        String gender = req.getParameter("gender");
        if (terms != null && terms.equals("terms")) {
            writer.println("<h2>Email " + email + "</h2>");
            writer.println("<h2>Password " + password + "</h2>");
            writer.println("<h2>Name " + name + "</h2>");
            writer.println("<h2>Gender " + gender + "</h2>");
        } else {
            writer.println("<h2>" + terms + "</h2>");
            writer.println("<h2>Please accept the terms and condition</h2>");
        }

    }

}
