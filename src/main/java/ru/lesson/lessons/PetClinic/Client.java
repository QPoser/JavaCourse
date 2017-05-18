package ru.lesson.lessons.PetClinic;

public class Client {
    private String name;
    private Pet pet = null;
    private long balance = 0;
    
    Client(String name) {
        this.name = name;
    }

    public void putBalance(long plusBalance) {
        this.balance = this.balance + plusBalance;
    }

    public long getBalance() {
        return this.balance;
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
            if (pet == null) {
                this.pet = null;
            }
            else {
                System.out.println(name + ": i have a pet!");
            }
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
            System.out.println(name + ": i don't have pet!");
        }
    }
    
    public void deletePet() {
        this.pet = null;
    }

    public boolean isHavePet() {
        if (this.pet != null) {
            return true;
        } else return false;
    }
    
    
}