package ru.lesson.lessons.PetClinic;

public class Cat extends Pet {
    
    Cat(String name, int years) {
        super(name, years);
    }
    
    public void voice() {
        System.out.println(getName() + " myau");
    }
    
    public String type() {
        return "cat";
    }
}