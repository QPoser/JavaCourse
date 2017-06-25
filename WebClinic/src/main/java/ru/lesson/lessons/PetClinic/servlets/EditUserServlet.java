package ru.lesson.lessons.PetClinic.servlets;

import ru.lesson.lessons.PetClinic.models.Pet;
import ru.lesson.lessons.PetClinic.models.User;
import ru.lesson.lessons.PetClinic.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Andrey on 01.06.2017.
 */
public class EditUserServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("user", this.USER_CACHE.getUser(Integer.valueOf(id)));
        req.setAttribute("pets", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Pet> pet = this.USER_CACHE.getUser(Integer.valueOf(req.getParameter("id"))).getPets();
        User us = new User(Integer.valueOf(req.getParameter("id")), req.getParameter("login"), req.getParameter("email"), req.getParameter("password"));
        us.putPets(pet);
        this.USER_CACHE.editUser(us);
        resp.sendRedirect(String.format("%s", req.getContextPath(), "/user/view"));
    }

    @Override
    public void destroy() {
        USER_CACHE.close();
    }
}
