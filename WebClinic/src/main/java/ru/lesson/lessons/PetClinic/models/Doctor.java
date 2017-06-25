package ru.lesson.lessons.PetClinic.models;

import java.util.ArrayList;

/**
 * Created by Andrey on 08.06.2017.
 */
public class Doctor {

    private final String name;
    private String password;
    private final String email;

    ArrayList<Integer> clientsId = new ArrayList<>();

    public Doctor(final String name, final String password, final String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
