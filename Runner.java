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
                calc.add(Integer.valueOf(first), Integer.valueOf(second));
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