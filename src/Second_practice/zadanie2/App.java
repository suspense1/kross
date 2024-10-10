package Second_practice.zadanie2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> Names = new ArrayList<>(Arrays.asList("Игра 1", "Игра 2","Игра 3","Игра 4","Игра 5","Игра 6", "Игра 7","Игра 8","Игра 9","Игра 10"));
        Map<String, BoardGame> boardGames = new HashMap<String, BoardGame>();

        Random r = new Random();
        for (String name : Names) {
            boardGames.put(name, new BoardGame(name, r.nextInt(2) + 2, r.nextInt(3) + 4, r.nextInt(4) + 1,r.nextInt(7) + 12,1000* (r.nextInt(4) + 1)));
        }
        GameShop gameShop = new GameShop(boardGames);

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < r.nextInt(6) + 2; i++) {
            customers.add(new Customer(Names.get(r.nextInt(Names.size())), 500*(r.nextInt(6) + 3)));
        }



        int count = 0;
        String res = "";
        for (Customer customer : customers) {
            BoardGame game = gameShop.buyGame(customer.getGameName(), customer.getMoney());
            if (game!=null){
                res+= "Игра " + customer.getGameName() + " успешно продана за " + customer.getMoney() + " рублей \n";
                count++;
            }
            else res+= "у покупателя недостаточно средств на счету \n";
        }
        res+="------------------- \n";
        res+= "Количество проданных игр: " + count + "\n";
        res+= "Полный зараобток: " +  gameShop.getEarnings();
        System.out.println(res);
    }
}
