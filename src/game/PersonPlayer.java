package game;

public class PersonPlayer extends Player {
    
    public PersonPlayer(String name) {
        this.name = name;
    }
    
    public PersonPlayer() {
        this.name = "Player 1";
    }

    public void generateMove(int m) {
        move = MoveType.values()[m];
    }
    
}
