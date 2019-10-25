package ChessGame;

class Player {
    final private String name;
    final private Color color;

    Player(String name, Color color){
        this.name = name;
        this.color = color;
    }

    String getName() {
        return name;
    }

    Color getColor() {
        return color;
    }
}
