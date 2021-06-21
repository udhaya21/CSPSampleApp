package com.cspsample.main;

import com.cspsample.utilities.Commons;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "app", urlPatterns = {"/home"})
public class Application extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (Exception e) {
            Commons.printStackTrace(e);
        }
    }

}
