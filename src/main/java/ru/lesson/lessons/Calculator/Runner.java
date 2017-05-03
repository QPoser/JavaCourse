package ru.lesson.lessons.Calculator;

import java.util.Scanner;

public class Runner {
    
    public static void main(String[] arg) {
        Scanner reader = new Scanner(System.in);
        try {
            Calculator calc = new Calculator();
            String exit = "no";
            while (!exit.equals("yes")) {
                System.out.println("Print 1st arg:");
                String first = reader.next();
                System.out.println("Enter 2st arg:");
                String second = reader.next();
                System.out.println("Choose opertation: plus|minus|multiply|dividing");
                String type = reader.next();
                switch (type) {
                    case "plus":
                        calc.plus(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                        
                    case "minus":
                        calc.minus(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                        
                    case "multiply":
                        calc.multiply(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                        
                    case "dividing":
                        calc.dividing(Integer.valueOf(first), Integer.valueOf(second));
                        break;
                        
                    default: 
                        System.out.println("Неправильный тип");
                        break;
                }
                System.out.println("Result: " + calc.getResult());
                calc.cleanResult();
                System.out.println("Exit : yes|no ");
                exit = reader.next();
            }
        } finally {
            reader.close();
        }
    }
}