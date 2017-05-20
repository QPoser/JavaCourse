package ru.lesson.lessons.PetClinic;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Вход в программу клиники
 */
public class ClinicStart {
    private static Controller control = new Controller();
    private static int level = 0;
    private static Client client = null;
    private static Clinic clinic = new Clinic("PetClinic");
    private static boolean hasPet = false;
    private static int clientId = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;
        Scanner scn = new Scanner(System.in);
        String name;
        ClientTest ct = new ClientTest(clinic);
        Thread ctThread = new Thread(ct);

        ctThread.start();
        
        clinic.callBack();
        
        while (!exit) {

            
        System.out.println("Take command: ");


        Integer cmd;



        switch (level) {

            case 0:
                putLogic();
                try {
                    cmd = scanner.nextInt();
                    scanner.nextLine();
                    switch (cmd) {

                        case 1:
                            System.out.println("Set client name:");
                            name = scn.next();
                            control.addClient(clinic, name);
                            level = 0;
                            break;


                        case 2:
                            System.out.println("Put client name:");
                            name = scn.next();
                            if (control.getClients(clinic, name)) {
                                level = 1;
                            }
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("No! Need int!");
                }
                    break;


            case 1:
                putLogic();
                cmd = scanner.nextInt();
                if (cmd == 0) {
                    level = 0;
                    break;
                }
                    //client = control.getClient(clinic, cmd);
                    if (control.getClient(clinic, cmd) != null) {
                        clientId = cmd;
                        level = 2;
                    } else {
                        level = 0;
                    }

                break;

            case 2:
                putLogic();
                cmd = scanner.nextInt();
                if (!hasPet) {
                    switch (cmd) {

                        case 0:
                            level = 0;
                            break;

                        case 1:
                            //AddPet
                            control.addPet(clinic, clientId);
                            //client = control.GetClient(clinic, clientId);
                            break;


                        case 2:
                            //Rename
                            control.rename(clinic, clientId);
                            break;

                        case 3:
                            //Put balance
                            control.setBalance(clinic, clientId);
                            break;

                        case 4:
                            //Get balance
                            control.getBalance(clinic, clientId);
                            break;

                        case 5:
                            //Delete Account
                            control.delete(clinic, clientId);
                            level = 0;
                            break;
                    }
                } else {
                    switch (cmd) {

                        case 0:
                            level = 0;
                            break;

                        case 1:
                            //Rename
                            control.rename(clinic, clientId);
                            break;

                        case 2:
                            //Rename pet
                            control.renamePet(clinic, clientId);
                            break;

                        case 3:
                            //Delete pet
                            control.deletePet(clinic, clientId);
                            break;

                        case 4:
                            //Put balance
                            control.setBalance(clinic, clientId);
                            break;

                        case 5:
                            //Get balance
                            control.getBalance(clinic, clientId);
                            break;

                        case 6:
                            //Delete
                            control.delete(clinic, clientId);
                            break;
                    }
                }
                break;

            default:
                System.out.println("Crash System!");
                level = 0;
                break;
        }
        }
        
        
    }

    private static void putLogic() {
        switch (level) {
            case 0:
            System.out.println("[1] - Add");
            System.out.println("[2] - Get");
            System.out.println("[0] - Exit");
            break;

            case 1:
                System.out.println("[0] - Back");
                break;

            case 2:
                int i = 1;
                if (control.getClient(clinic, clientId) != null) {
                    System.out.println("Name: " + control.getClient(clinic, clientId).getName());
                    System.out.println("Balance: " + control.getClient(clinic, clientId).getBalance());
                    if (control.getClient(clinic, clientId).getPet() != null) {
                        hasPet = true;
                        System.out.println(control.getClient(clinic, clientId).getName() + " " + control.getClient(clinic, clientId).getPet().getName());
                        System.out.println("[1] - Rename");
                        System.out.println("[2] - Rename pet");
                        System.out.println("[3] - Delete pet");
                        System.out.println("[4] - Put balance");
                        System.out.println("[5] - Get balance");
                        System.out.println("[6] - Delete");
                    }
                    else {
                        hasPet = false;
                        System.out.println("[1] - AddPet");
                        System.out.println("[2] - Rename");
                        System.out.println("[3] - Put balance");
                        System.out.println("[4] - Get balance");
                        System.out.println("[5] - Delete");
                    }
                    System.out.println("[0] - Back");
                } else {
                    level = 0;
                    System.out.println("Fatal Error!");
                }
                break;

                default:
                    System.out.println("What?:)");
                    break;
        }
    }
}