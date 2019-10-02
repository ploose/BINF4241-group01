// Created by Patrick Looser

package ch.sc.snakesandladders;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class Players {

    private Queue<String> playerQueue = new LinkedList<>();

    public void setQueue(List inputList) {

        this.playerQueue.addAll(inputList);

    }

    public List getQueue(){

        return (List) this.playerQueue;
    }

}
