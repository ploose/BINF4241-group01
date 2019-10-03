// Created by Patrick Looser

package ch.sc.snakesandladders;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import Player;

public class Players {


    private Queue<Player> playerQueue;
    private ArrayList<Player> playerList;


    public Players(ArrayList playerList){
        this.playerList = playerList;

    }

    private Queue initQueue(ArrayList playerList){

        this.playerQueue.addAll(playerList);

    }

    public List getQueue(){

        return (List) this.playerQueue;
    }

    public Player remove(){

        return playerQueue.remove();

    }

    public void add(Player Player){

        playerQueue.add(Player);

    }

}
