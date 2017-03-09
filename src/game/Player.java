package game;

import java.io.Serializable;

public abstract class Player implements Serializable {
    
    protected String name;
    private int wins = 0;
    protected MoveType move;
    private String color;
    
    public String getName() { return name; }
    public void changeName(String name) { this.name = name; }

    
    public void incrementWins() { wins++; }
    public int getWins() { return wins; }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() { return color; }
    
    public MoveType getMove() { return move; }
    // public abstract void generateMove(int m);
    
    public int compareTo(Player opp) {
        int move1 = this.move.value;
        int move2 = opp.move.value;
        
        switch (move1) {
            // player chooses rock
            case 0:
                if (move2 == 1) {
                    System.out.println("PAPER beats ROCK");
                    this.setColor("#f45041");
                    opp.setColor("#42f448");
                    return -1;
                } else if (move2 == 2) {
                    System.out.println("ROCK beats SCISSORS");
                    this.setColor("#42f448");
                    opp.setColor("#f45041");
                    return 1;
                }
                break;
            // player chooses paper
            case 1:
                if (move2 == 0) {
                    System.out.println("SCISSORS beats PAPER");
                    this.setColor("#f45041");
                    opp.setColor("#42f448");
                    return -1;
                } else if (move2 == 2) {
                    System.out.println("PAPER beats ROCK");
                    this.setColor("#42f448");
                    opp.setColor("#f45041");
                    return 1;
                }
                break;
            // player chooses scissors
            case 2:
                if (move2 == 0) {
                    System.out.println("ROCK beats SCISSORS");
                    this.setColor("#f45041");
                    opp.setColor("#42f448");
                    return -1;
                } else if (move2 == 1) {
                    System.out.println("SCISSORS beats PAPER");
                    this.setColor("#42f448");
                    opp.setColor("#f45041");
                    return 1;
                }
                break;
        }
        System.out.println("It's a tie!");
        this.setColor("#000000");
        opp.setColor("#000000");
        return 0;
        
    }

        
}
