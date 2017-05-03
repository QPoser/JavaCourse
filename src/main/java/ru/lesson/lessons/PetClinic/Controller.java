package ru.lesson.lessons.PetClinic;

public class Controller {
    Pet pet = null;
    Client client = null;
    
    public void Add(Clinic clinic, String parts[]) {
        switch (parts[1].toLowerCase()) {
            case "client":
                 if (clinic.isCanAdd(parts[2])) {
                    Client client = new Client(parts[2]);
                    clinic.addClient(client);
                    System.out.println(client.getName() + " Added");
                    break;
                }
                 else {
                    System.out.println("Cant");
                    break;
                } 
                
            case "pet":
                Client client = clinic.getClient(parts[5]);
                if (client != null) {
                    switch(parts[2]) {
                        case "cat":
                            pet = new Cat(parts[3], Integer.parseInt(parts[4]));
                            client.setPet(pet);
                            break;
                            
                        case "dog":
                            pet = new Dog(parts[3], Integer.parseInt(parts[4]));
                            client.setPet(pet);
                            break;
                    }
                    break;
                }
                else {
                    System.out.println("Cant find client " + parts[5]);
                break;
                }
        }
    }
    
    public void Get(Clinic clinic, String parts[]) {
         client = clinic.getClient(parts[2]);
        switch (parts[1]) {
            case "client":
                if (client == null) {
                    System.out.println("Cant find client!");
                } else {
                    System.out.println(client.getName() + " Searched");
                }
                break;
                
            case "pet":
                if (client == null) {
                    System.out.println("Cant find client!");
                } else {
                    pet = client.getPet();
                    if (pet != null) {
                    System.out.println("Pet name - " + pet.getName() + ", years old - " + pet.getAge() + " and type - " + pet.type());
                    } else {
                        System.out.println(client.getName() + " haven't pet");
                    }
                }
                break;
        }
            
    }
    
    public void Find(Clinic clinic, String parts[]) {
        clinic.findPet(parts[2]);
    }
    
    public void Rename(Clinic clinic, String parts[]) {
        client = clinic.getClient(parts[2]);
            if (client != null) {
        switch (parts[1].toLowerCase()) {
            case "client":
                if (clinic.isCanAdd(parts[3])) {
                client.rename(parts[3]);
                System.out.println(parts[2] + " is now " + parts[3]);
                } else System.out.println(parts[3] + " closed!");
                break;
                
            case "pet":
                if (client.getPet() != null) {
                    System.out.println("Pet: " + client.getPet().getName() + " is now " + parts[3]);
                    client.renamePet(parts[3]);
                } else System.out.println(client.getName() + " have not pet!");
                break;
        }
      } else System.out.println(parts[2] + " dont find");
    }
    
    public void Delete(Clinic clinic, String parts[]) {
        switch (parts[1]) {
            case "client":
                clinic.deleteClient(parts[2]);
                break;
                
            case "pet":
                client = clinic.getClient(parts[2]);
                if (client != null) {
                    client.deletePet();
                    System.out.println("Pet deleted!");
                } else System.out.println(parts[2] + " dont found!");
                break;
        }
    }
    
    
}