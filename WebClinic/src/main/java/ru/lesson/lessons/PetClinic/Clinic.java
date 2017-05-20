package ru.lesson.lessons.PetClinic;

import java.util.*;

public class Clinic {
    //private List<Client> clients = new ArrayList<Client>();
    private Map<Integer, Client> clientMap = new TreeMap<Integer, Client>();
    //private Client CurrentClient = new Client("None");
    private String name;
    
    Clinic(String name) {
        this.name = name;  
    }
    
    public void callBack() {
        System.out.println("Clinic " + name + " hello to you!");
    }
    
    public void addClient(Client client) {
                clientMap.put(clientMap.size()+1, client);
                System.out.println(client.getName() + " added");
            }

    
    public boolean getClients(String name) {
        Map<Integer, Client> retClient = new HashMap<Integer, Client>();
        for(Integer i : clientMap.keySet()) {
            if (clientMap.get(i).getName().equals(name)) {
                retClient.put(i, clientMap.get(i));
            }
        }
        if (retClient.size() == 0) {
            System.out.println("Clients with name " + name + " doesn't found");
            return false;
        }
        for (Integer i : retClient.keySet()) {
            System.out.println("[" + i +"] " + retClient.get(i).getName());
        }
        return true;
    }

    public Client getClient(int id) {
        if (clientMap.containsKey(id)) {
            return clientMap.get(id);
        } else {
            System.out.println("No Client!");
            return null;
        }
    }

    
    public boolean getPets(String petName) {
        Boolean contPet = false;
        for (Integer i : clientMap.keySet()) {
            if (clientMap.get(i).getPet() != null && clientMap.get(i).getPet().getName().equals(petName)) {
                System.out.println("[" + i + "] " + clientMap.get(i).getName() + " have a pet " + clientMap.get(i).getPet().getName());
                contPet = true;
            }
        }
        return contPet;
    }
    
    public void deleteClient(int id) {
        if (clientMap.containsKey(id)) {
            System.out.println("Client " + clientMap.get(id).getName() + " deleted!");
            clientMap.remove(id);
        } else {
            System.out.println("No client with id [" + id + "]");
        }
    }
}