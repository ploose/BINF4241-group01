package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// TODO: Mention change to public in Javadoc / Answers
public class Players {
    private LinkedList<Player> playerQueue;

    public Players(ArrayList<Player> playerList){
        playerQueue = new LinkedList<>();
        initQueue(playerList);
    }

    private void initQueue(ArrayList<Player> playerList){
        playerQueue.addAll(playerList);
    }

    List<Player> getQueue(){
        return playerQueue;
    }

    Player getCurrentPlayer(){
        return playerQueue.remove();
    }

    void add(Player Player){
        playerQueue.add(Player);
    }
}
