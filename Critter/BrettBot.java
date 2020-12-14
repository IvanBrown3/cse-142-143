public class BrettBot extends BotCritter{
    private boolean fight;
    private int move;
    private String letter;

    public BrettBot(){
        move = 0;
        fight = true;
        letter = "B";
    }
    public boolean eat(){
        return false;
    }
    public Direction getMove(){
        move++;
        if(move == 1){
            return Direction.NORTH;
        }
        else if(move == 2){
            return Direction.EAST;
        }
        else if(move == 3){
            return Direction.SOUTH;
        }
        else{
            move = 0;
            return Direction.WEST;
        }
    }
    
    public String toString(){
        return letter;
        }
    
      public Attack fight(String opponent) {
        this.letter = "W";
        if (opponent.equals("B") || opponent.equals("W")) {
            return Attack.FORFEIT;
        } else if (opponent.equals("S")) {
            return Attack.ROAR;
        } else if (opponent.equals("T")) {
            return Attack.POUNCE;
        } else {
            return Attack.SCRATCH;
        }
    }
}

