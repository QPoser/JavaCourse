package ru.lesson.lessons.PetClinic.servlets;

import ru.lesson.lessons.PetClinic.models.Cat;
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

/**
 * Created by Andrey on 01.06.2017.
 */
public class CreatePetServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("user", this.USER_CACHE.getUser(id));
        req.setAttribute("pets", this.USER_CACHE.getUser(id).getPets());
        req.setAttribute("addPet", req.getParameter("addPet"));
        req.setAttribute("editPet", req.getParameter("editPet"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/SetPet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostProcess(req);
        resp.sendRedirect(String.format("%s", req.getContextPath(), "/user/edit"));
    }

    private void PostProcess(HttpServletRequest req) {
        ppAddPet(req);
        ppEditPet(req);

    }

    private void ppAddPet(HttpServletRequest req) {
        if (req.getParameter("addPet") != null) {
            User us = this.USER_CACHE.getUser(Integer.valueOf(req.getParameter("id")));
            Pet pet = null;
            pet = typeOfPet(req);
            us.putPet(pet);
            this.USER_CACHE.editUser(us);
        }
    }

    private void ppEditPet(HttpServletRequest req) {
        if (req.getParameter("editPet") != null) {
            User us = this.USER_CACHE.getUser(Integer.valueOf(req.getParameter("id")));
            Pet pet = null;
            us.deletePet(req.getParameter("petName"));
            pet = typeOfPet(req);
            us.putPet(pet);
            this.USER_CACHE.editUser(us);
        }
    }

    private Pet typeOfPet(HttpServletRequest req) {
        Pet pet = null;
        switch (req.getParameter("select")) {
            case "cat":
                pet = new Cat(req.getParameter("name"), Integer.valueOf(req.getParameter("age")));
                break;

            case "dog":
                pet = new Dog(req.getParameter("name"), Integer.valueOf(req.getParameter("age")));
                break;
        }
        return pet;

    }


}
