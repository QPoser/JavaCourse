package ru.lesson.lessons.PetClinic.models;

import java.util.ArrayList;

/**
 * Created by Andrey on 31.05.2017.
 */
public class User {
    private final int id;
    private final String login;
    private final String email;
    private String password;
    private ArrayList<Pet> pets = new ArrayList<Pet>();

    public User(final int id, final String login, final String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
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

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    public Pet getPet(String name) {
        for (Pet p : this.pets) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public boolean putPet(Pet pet) {
        for (Pet p : this.pets) {
            if (p.getName().equals(pet.getName())) {
                return false;
            }
        }
        this.pets.add(pet);
        return true;
    }

    public void putPets(ArrayList<Pet> pets1) {
        for (Pet pet : pets1) {
            putPet(pet);
        }
    }

    public void deletePet(String name) {
        for (Pet pet : this.pets) {
            if (pet.getName().equals(name)) {
                this.pets.remove(pet);
            }
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}

