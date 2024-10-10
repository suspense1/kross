package Third_practice.Zadanie2;

import java.util.Random;

public class Main {
    /*
        В одном МФЦ работают три окна, которые обслуживают три категории граждан: молодые, пожилые и бизнесмены.
        Окна работают без очередей (каждый гражданин является отдельным потоком).
        Первое окно принимает любые категории граждан, второе - только вторую категорию, а третье - только третью.
        Гражданин идёт в случайное окно.
        Если гражданин не может получить услугу из-за занятости окна или неверной категории, то он разгневанно уходит.
        Определить процент ушедших клиентов из каждой категории.
     */


    public enum Window_type{
        universal,
        pozilie,
        business
    }
    public enum Visitor_type{
        molodie,
        pozilie,
        business
    }

    static Window[] windows = {new Window(Window_type.universal), new Window(Window_type.universal), new Window(Window_type.universal)};

    public static Window GetWindows(){
        int pick = new Random().nextInt(windows.length);
        return windows[pick];
    }
    public static void main(String[] args) {

        while (true){

            int pick = new Random().nextInt(Visitor_type.values().length);

            Citizen vizitor = new Citizen(Visitor_type.values()[pick]);

            Thread thread = new Thread(vizitor);

            thread.start();

            for(int i = 0; i < windows.length; i++){
                System.out.println("Окно: " + i);
            }
        }

    }
}
