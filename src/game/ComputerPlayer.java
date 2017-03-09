package game;

import java.util.Random;

public class ComputerPlayer extends Player {
    
    public void generateMove() {
        Random rand = new Random();
        move = MoveType.values()[rand.nextInt(3)];
    }
    
    public ComputerPlayer(String name) {
        this.name = name;
    }
    
    public ComputerPlayer() {
        this.name = "Computer";
    }
    
}
