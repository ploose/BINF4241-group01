package ChessGame;

class Player {
    final private String name;
    private boolean isChecked;

    Player(String name){
        this.name = name;
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
}
