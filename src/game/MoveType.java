package game;

/*
 * Stores the different move types as an enum
 */
public enum MoveType {
    
    ROCK(0),
    PAPER(1),
    SCISSORS(2);
    
    public int value;
    
    private MoveType(int value) {
        this.value = value;
    }
}
