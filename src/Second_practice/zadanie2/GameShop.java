package Second_practice.zadanie2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameShop {

    private Map<String, BoardGame> gamesCatalog;
    private float earnings;

    public GameShop(Map<String, BoardGame> incomingGames) {

        this.gamesCatalog = incomingGames;
        this.earnings = 0;
    }

    public BoardGame buyGame(String game_name, float cash) {

            if ((this.gamesCatalog.containsKey(game_name)==true)&&(this.gamesCatalog.get(game_name).getPrice() <= cash)) {
            earnings += cash;
            return this.gamesCatalog.remove(game_name);
            }

        else return null;
    }

    public float getEarnings() {
        return earnings;
    }

    public List<BoardGame> getCatalog() {
        return new ArrayList<>(gamesCatalog.values());
    }
}
