package ru.lesson.lessons.PetClinic;

import java.util.Scanner;
import java.io.*;

/**
 * Вход в программу клиники
 */
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
                try {
                    control.Add(clinic, parts);
                } catch (Exception p) {
                    System.out.println("Введите корректные поля, для клиента - 3, для животного - 6");
                }
                break;
                
                
            case "get":
                control.Get(clinic, parts);
                break;
                
            case "find":
                control.Find(clinic, parts);
                break;
                
            case "rename":
                control.Rename(clinic, parts);
                break;
                
            case "delete":
                control.Delete(clinic, parts);
                break;
                
                
                
            case "exit":
            System.out.println("Exit! Goodbye!");
                exit = true;
                break;
                
        }
            
        }
        
        
    }
}