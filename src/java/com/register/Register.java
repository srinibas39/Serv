package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

//need to include multipartconfig for telling the sevlet that we need to file upload
@MultipartConfig
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Part imageFile = request.getPart("image");
            String imageName = imageFile.getSubmittedFileName();

            // Now save the data in the database
            out.println(name);
            out.println(email);
            out.println(password);
            out.println(imageName);

            // Saving in the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "8895799681s");

                out.println("connection made");
//                 Create a prepared statement
                String q = "INSERT INTO users(name, email, password,imageName) VALUES (?, ?, ?,?)";
                PreparedStatement stmt = conn.prepareStatement(q);
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, imageName);

                stmt.executeUpdate();
                
                //Image/File UPloading 
                //Read the data from  inputStream
                InputStream is=imageFile.getInputStream();
                //creating a byte array
                byte[] data = new byte[is.available()];
                
                //storing the input stream data in the byte array
                is.read(data);
                
                String path = request.getServletContext().getRealPath("/uploads")+File.separator+imageName;
                out.println(path);
                FileOutputStream fos = new FileOutputStream(path);
                
                fos.write(data);
                fos.close();
                out.println("<p>Data inserted successfully into the database.</p>");

                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }

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
