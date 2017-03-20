package game;

import java.io.Serializable;

public class Game implements Serializable {
    
    public PersonPlayer p1 = new PersonPlayer();
    public ComputerPlayer cpu = new ComputerPlayer();
    
    private String winMessage = "";
       
    public void compare(int pMove) {
        p1.generateMove(pMove);
        cpu.generateMove();
        
        switch (p1.compareTo(cpu)) {
            case 1:
                p1.incrementWins();
                winMessage = "You win!";
                break;
            case -1:
                cpu.incrementWins();
                winMessage = "Computer wins!";
                break;
            default:
                winMessage = "It's a tie!";
                break;
        }
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
