import java.awt.*;

public class GoldFish extends Critter {
    
    private boolean walkNorth;
    private int move;

    public GoldFish(boolean walkNorth){
        walkNorth = true;
        move = 0;
    }

	public boolean eat() {
		return true;
	}

	public Attack fight(String opponent) {
        walkNorth = false;
		return Attack.SCRATCH;
	}

	public Direction getMove() {
        move++;
        while(move % 10 != 0){
            if(move % 10 == 10){
                move = 0;
            }
            if(walkNorth){
                return Direction.NORTH;
            }
            else{
                return Direction.SOUTH;
            }
        }
    }

    public Color getColor() {
        return Color.YELLOW;
    }
    
	public String toString() {
		return "#";
    }
}