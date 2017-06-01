package ru.lesson.lessons.PetClinic.models;

import ru.lesson.lessons.PetClinic.models.Pet;

public class Dog extends Pet {
    
    public Dog(String name, int years) {
        super(name, years);
    }
    
    public void voice() {
        System.out.println(getName() + " Guav Guav");
    }
    
    public String type() {
        return "dog";
    }
}