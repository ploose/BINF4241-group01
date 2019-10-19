package ChessGame;

import java.util.ArrayList;

public class Player {
    final private String name;
    final private Color color;
    private boolean isChecked;

    Player(String name, Color color){
        this.name = name;
        this.color = color;
        isChecked = false;
    }

    boolean isChecked(){
        return isChecked;
    }

    void check() {
        isChecked = true;
    }

    String getName() {
        return name;
    }

    Color getColor() {
        return color;
    }
}
