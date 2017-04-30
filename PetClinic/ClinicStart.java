import java.util.Scanner;
import java.io.*;

public class ClinicStart {
    private static Controller control = new Controller();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clinic clinic = new Clinic("PetClinic");
        Client client = null;
        Boolean exit = false;
        
        clinic.callBack();
        
        while (!exit) {
            
            System.out.println("Take command: ");
        
        String command = scanner.nextLine();
        
        String parts[] = command.split(" ");
            
        
        switch (parts[0]) {
                
            case "add": 
                control.Add(clinic, parts);
                break;
                
                
            case "get":
                control.Get(clinic, parts);
                break;
                
                
            case "exit":
            System.out.println("Exit! Goodbye!");
                exit = true;
                break;
                
        }
            
        }
        
        
    }
}