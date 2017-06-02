package ru.lesson.lessons.PetClinic.models;

public abstract class Pet {
    private String name;
    private int yearOld;
    private int hp = 50;
    private int id;
    
    
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

    public final void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public abstract String voice();
    
    public abstract String type();
}