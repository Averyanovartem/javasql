package com.netcracker.testsystem.servlets;

import com.netcracker.testsystem.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> names = model.listUsers();
        req.setAttribute("userNames", names);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/listUsers.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        Model model = Model.getInstance();
        model.deleteUser(userId);

        req.setAttribute("deletedUserId", userId);
        doGet(req, resp);

    }
}
