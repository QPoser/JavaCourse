package ru.lesson.lessons.PetClinic.servlets;

import ru.lesson.lessons.PetClinic.models.User;
import ru.lesson.lessons.PetClinic.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Andrey on 31.05.2017.
 */
public class CreateUserServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = this.ids.incrementAndGet();
        this.USER_CACHE.add(new User(id, req.getParameter("login"), req.getParameter("email"), req.getParameter("password"), "user"));
        id = USER_CACHE.findByLogin(req.getParameter("email")).getId();
        req.setAttribute("uid", String.valueOf(id));
        req.setAttribute("type", "user");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        USER_CACHE.close();
    }
}
