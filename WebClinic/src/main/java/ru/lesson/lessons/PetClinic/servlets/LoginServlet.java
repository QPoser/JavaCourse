package ru.lesson.lessons.PetClinic.servlets;

import ru.lesson.lessons.PetClinic.models.User;
import ru.lesson.lessons.PetClinic.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 25.06.2017.
 */
public class LoginServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        User us = USER_CACHE.findByLogin(email);
        try {
            if (us.getPassword().equals(pass)) {
                req.setAttribute("uid", String.valueOf(us.getId()));
                req.setAttribute("type", "user");
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/");
            dispatcher.forward(req, resp);
        } catch (NullPointerException e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        USER_CACHE.close();
    }
}
