package com.example.demo5;

import java.io.*;
import java.sql.SQLException;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Resource(name = "jdbc/privat")
    DataSource ds;
    DirectorDAO directorDAO;

    private String message;

    public void init() {
        message = "Hello World!";
        try {
            directorDAO = new DirectorDAO(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<ul>");
        for (Director director : directorDAO.findAll()) {
            out.println("<li>"+director.getName()+"</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("userage"));
        UserBean ub = new UserBean(username, age);
        request.setAttribute("ub", ub);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }

    public void destroy() {
    }
}