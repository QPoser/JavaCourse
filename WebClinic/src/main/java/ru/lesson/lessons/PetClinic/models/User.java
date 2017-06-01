package ru.lesson.lessons.PetClinic.models;

import java.util.ArrayList;

/**
 * Created by Andrey on 31.05.2017.
 */
public class User {
    private final int id;
    private final String login;
    private final String email;
    private Pet pet = null;

    public User(final int id, final String login, final String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void putPet(Pet pet) {
        this.pet = pet;
    }

    public void deletePet(Pet pet) {
        this.pet = null;
    }
}

