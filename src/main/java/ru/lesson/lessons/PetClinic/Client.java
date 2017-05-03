package ru.lesson.lessons.PetClinic;

public class Client {
    private String name;
    private Pet pet = null;
    
    Client(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Pet getPet() {
        return pet;
    }
    
    public void setPet(Pet pet) {
        if (this.pet == null) {
        this.pet = pet;
            System.out.println(name + ": pet setted!");
        }
        else {
            System.out.println(name + ": i have a pet!");
        }
    }
    
    public void rename(String name) {
        this.name = name;
    }
    
    public void renamePet(String petName) {
        if (pet != null) {
        pet.rename(petName);
        }
        else {
            System.out.println(name + ": i dont have pet!");
        }
    }
    
    public void deletePet() {
        this.pet = null;
    }
    
    
}