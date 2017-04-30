public class Clinic {
    private Client[] clients = new Client[15];
    private Client NoneClient = new Client("None");
    private String name;
    
    Clinic(String name) {
        this.name = name;  
    }
    
    public void callBack() {
        System.out.println("Clinic " + name + " hello to you!");
    }
    
    public void addClient(Client client) {
        Boolean place = false;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = client;
                place = true;
                System.out.println(client.getName() + " added");
                break;
            }
            
        }
        if (!place) {
            System.out.println("Havent place");
        }
    }
    
    public Client getClient(String name) {
        for(int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
            if (clients[i].getName().equals(name)) {
                return clients[i];
            }
            }
        }
        return null;
    }
    
    public Boolean isCanAdd(String clientName) {
        Client testClient = getClient(clientName);
        if (testClient == null) {
            return true;
        } else {
            return false;
        }
    }
}