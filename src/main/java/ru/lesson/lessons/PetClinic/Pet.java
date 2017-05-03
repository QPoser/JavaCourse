package ru.lesson.lessons.PetClinic;

public abstract class Pet {
    private String name;
    private int yearOld;
    private int hp = 50;
    
    
    Pet(String name, int years) {
        this.name = name;
        this.yearOld = years;
    }
    
    public void plusAge() {
        yearOld++;
    }
    
    public int getAge() {
        return this.yearOld;
    }
    
    public void Health() {
        hp = 100;
    }
    
    public void rename(String name) {
        this.name = name;
    }
    
    public int test() {
        return hp;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public abstract void voice();
    
    public abstract String type();
}