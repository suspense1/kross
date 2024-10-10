package Third_practice.Zadanie1;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer implements Runnable {

    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Write -----------------------");
            Random random = new Random();
            int temp = random.nextInt(10000);
            System.out.println("Number: " + temp);
            listOfNumbers.add(random.nextInt(temp));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
