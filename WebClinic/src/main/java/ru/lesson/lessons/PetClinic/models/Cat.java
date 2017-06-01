package ru.lesson.lessons.PetClinic.models;

import ru.lesson.lessons.PetClinic.models.Pet;

public class Cat extends Pet {
    
    public Cat(String name, int years) {
        super(name, years);
    }
    
    public void voice() {
        System.out.println(getName() + " myau");
    }
    
    public String type() {
        return "cat";
    }
}