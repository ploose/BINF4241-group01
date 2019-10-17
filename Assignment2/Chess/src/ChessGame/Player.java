package ChessGame;

import java.util.ArrayList;

public class Player {
    final private String name;
    final private Color color;
    private boolean isChecked;
    private ArrayList<Piece> lost;

    Player(String name, Color color){
        this.name = name;
        this.color = color;
        isChecked = false;

        lost = new ArrayList<>();
    }

    public boolean isChecked(){
        return isChecked;
    }

    void check() {
        isChecked = true;
    }

    String getName() {
        return name;
    }

    String lostPieces() {
        StringBuilder list = new StringBuilder();

        for (Piece element : lost) {
            list.append(element);
        }
        return list.toString();
    }
}
