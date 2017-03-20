package game;

import java.io.Serializable;

public class Game implements Serializable {
    
    public PersonPlayer p1 = new PersonPlayer();
    public ComputerPlayer cpu = new ComputerPlayer();
    
    private String winMessage = "";
       
    public void compare(int pMove) {
        p1.generateMove(pMove);
        cpu.generateMove();
        
        if (p1.compareTo(cpu) == 1) {
            p1.incrementWins();
            winMessage = p1.getName() + " wins!";
        } else if (p1.compareTo(cpu) == -1) {
            cpu.incrementWins();
            winMessage = cpu.getName() + " wins!";
        }
        winMessage = "It's a tie!";
    }
    
    public String getWinMessage() {
        return winMessage;
    }
    
    public Game() {
        
    }
    
    public Game(PersonPlayer p1, ComputerPlayer cpu) {
        this.p1 = p1;
        this.cpu = cpu;
    }
    
}
