package ru.lesson.lessons.PetClinic.servlets;


import ru.lesson.lessons.PetClinic.models.Dog;
import ru.lesson.lessons.PetClinic.models.Pet;
import ru.lesson.lessons.PetClinic.models.User;
import ru.lesson.lessons.PetClinic.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Andrey on 20.05.2017.
 */
public class ClinicServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getInstance();

    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = (String) req.getAttribute("type");
        if (type != null) {
            User user = USER_CACHE.getUser(Integer.valueOf((String) req.getAttribute("userId")));
            req.setAttribute("type", type);
            req.setAttribute("user", user);
        } else {
            req.setAttribute("type", "guest");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/site/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = (String) req.getAttribute("type");
        String uid = (String) req.getAttribute("uid");
        if (type != null) {
            User user = USER_CACHE.getUser(Integer.valueOf(uid));
            req.setAttribute("type", type);
            req.setAttribute("user", user);
        } else {
            req.setAttribute("type", "guest");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/site/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        USER_CACHE.close();
    }
}
