package ru.lesson.lessons.PetClinic;

public class Dog extends Pet {
    
    Dog(String name, int years) {
        super(name, years);
    }
    
    public void voice() {
        System.out.println(getName() + " Guav Guav");
    }
    
    public String type() {
        return "dog";
    }
}