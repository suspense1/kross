package Third_practice.Zadanie1;

import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable {

    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println("Read -----------------------");
            for (Integer num : listOfNumbers) {
                System.out.println("Number: " + num);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
