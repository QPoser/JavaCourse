package ru.lesson.lessons.PetClinic.servlets;

import ru.lesson.lessons.PetClinic.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 03.06.2017.
 */
public class DeletePetServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("id");
        String namePet = req.getParameter("petName");
        this.USER_CACHE.getUser(Integer.valueOf(s)).deletePet(namePet);
        req.setAttribute("user", this.USER_CACHE.getUser(Integer.valueOf(s)));
        req.setAttribute("pets", this.USER_CACHE.getUser(Integer.valueOf(s)).getPets());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(req, resp);
    }
}
