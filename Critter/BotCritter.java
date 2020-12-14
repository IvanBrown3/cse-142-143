import java.awt.*;

public class BotCritter extends Critter {
    private boolean attack;

    public Color getColor() {
        this.attack = true;
		return Color.BLUE;
	}

    public Attack fight(String opponent) {
        attack = false;
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