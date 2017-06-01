package ru.lesson.lessons.PetClinic.servlets;

import ru.lesson.lessons.PetClinic.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 01.06.2017.
 */
public class DeleteUserServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        this.USER_CACHE.delete(Integer.valueOf(id));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
