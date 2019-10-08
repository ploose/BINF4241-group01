package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Players {
    private LinkedList<Player> playerQueue;

    Players(ArrayList<Player> playerList){
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
