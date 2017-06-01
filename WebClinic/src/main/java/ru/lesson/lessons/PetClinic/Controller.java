package ru.lesson.lessons.PetClinic;

import ru.lesson.lessons.PetClinic.models.Cat;
import ru.lesson.lessons.PetClinic.models.Dog;
import ru.lesson.lessons.PetClinic.models.Pet;

import java.util.Scanner;

public class Controller {
    Pet pet = null;
    Client client = null;


    public void addClient(Clinic clinic, String name) {
            Client client = new Client(name);
            clinic.addClient(client);
        }
    
    public boolean getClients(Clinic clinic, String name) {
                return clinic.getClients(name);
    }

    public Client getClient(Clinic clinic, int id) {
        return clinic.getClient(id);
    }

    public void putClient(Clinic clinic, int id, Client client) {
    }

    
    public Boolean getPets(Clinic clinic, String namePet) {
        return clinic.getPets(namePet);
    }
    //
    public void rename(Clinic clinic, Integer id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print name:");
        String name = scanner.nextLine();
        clinic.getClient(id).rename(name);
    }

    public void addPet(Clinic clinic, Integer id) {
        //Addpet function
        System.out.println("Put:");
        System.out.println("Type / Name / Age");
        Boolean b = true;
        while (b) {
            Scanner scanner = new Scanner(System.in);
            String parts[] = scanner.nextLine().split(" ");
            switch (parts[0].toLowerCase()) {
                case "dog":
                    pet = new Dog(parts[1], Integer.parseInt(parts[2]));
                    b = false;
                    break;

                case "cat":
                    pet = new Cat(parts[1], Integer.parseInt(parts[2]));
                    b = false;
                    break;

                default:
                    System.out.println("Bad parse, put:");
                    System.out.println("Type / Name / Age");
                    break;
            }
        }
        clinic.getClient(id).setPet(pet);
    }

    public void renamePet(Clinic clinic, Integer id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print pet name:");
        String namePet = scanner.nextLine();
        clinic.getClient(id).renamePet(namePet);
    }

    public void deletePet(Clinic clinic, Integer id) {
        clinic.getClient(id).setPet(null);
        System.out.println("Pet deleted!");
    }

    //
    public void delete(Clinic clinic, Integer id) {
        clinic.deleteClient(id);
    }

    public void getBalance(Clinic clinic, Integer id) {
        System.out.println(clinic.getClient(id).getBalance());
    }

    public void setBalance(Clinic clinic, Integer id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put balance:");
        long put = scanner.nextLong();
            clinic.getClient(id).putBalance(put);
            System.out.println("Success, current balance - " + clinic.getClient(id).getBalance());
    }

    
    
}