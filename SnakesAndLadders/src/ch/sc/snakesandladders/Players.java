

package ch.sc.snakesandladders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Players {
    private LinkedList<Player> playerQueue;

    Players(ArrayList<Player> playerList){
        playerQueue = new LinkedList<>();
        initQueue(playerList);
    }

    private void initQueue(ArrayList<Player> playerList){
        playerQueue.addAll(playerList);
    }

    public List<Player> getQueue(){
        return playerQueue;
    }

    Player getCurrentPlayer(){
        return playerQueue.remove();
    }

    void add(Player Player){
        playerQueue.add(Player);
    }

    //Added remove function
    public Player remove(){
        return playerQueue.remove();
    }
}
