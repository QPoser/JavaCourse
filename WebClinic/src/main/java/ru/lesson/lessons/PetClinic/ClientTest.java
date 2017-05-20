package ru.lesson.lessons.PetClinic;

/**
 * Created by Andrey on 18.05.2017.
 */
public class ClientTest extends Thread {
    private Clinic clinic = null;

    ClientTest(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        super.run();
        Controller control = new Controller();
        clinic.addClient(new Client("Tester"));
        while (true) {
            clinic.getClient(1).putBalance(100);
            System.out.println("                                                    Tester is + " + clinic.getClient(1).getBalance());
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
