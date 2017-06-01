package ru.lesson.lessons.PetClinic.servlets;


import ru.lesson.lessons.PetClinic.models.Dog;
import ru.lesson.lessons.PetClinic.models.Pet;

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

    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
        /*resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                "<html>" +
                        "<head>" +
                        "<title>Clinic</title>" +
                        "</head>" +
                        "<body><span>open</span>" +
                        "<form action = '" + req.getContextPath()+"/' method='post'>" +
                        "Name : <input type = 'text' name= 'name'>" +
                        "<input type='submit' value='Submit'>" + this.viewPets() +
                        "</body>" +
                        "</html>"
        );
        writer.flush(); */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.pets.add(new Dog(req.getParameter("name"), 5));
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (Pet pet : this.pets) {
                sb.append("<tr><td style='border : 1px solid black'>").append(pet.getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
