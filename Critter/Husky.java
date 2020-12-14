//Ivan Brown
//TA: CC Sent
//12/8/20
//This program is the functional class for when an husky is created in the critter simulation. The husky will 
//rotate through the colors of the rainbow each move it makes. The string in the critter simulation will be meef. 
//This is a word meaning consume. The husky will always eat, move west and scratch in fight.

import java.awt.*;

//extends the base class of a critter
public class Husky extends Critter{

    //private int field for movement count created
    private int movement;

    //husky constructor sets movement to zero
    public Husky(){
        movement = 0;
    }

    //this method returns the color of the husky
    //the color returned is green
    public Color getColor(){
        if(movement % 6 == 0){
            return Color.RED;
        }
        else if(movement % 6 == 1){
            return Color.ORANGE;
        }
        else if(movement % 6 == 2){
            return Color.YELLOW;
        }
        else if(movement % 6 == 3){
            return Color.GREEN;
        }
        else if(movement % 6 == 4){
            return Color.BLUE;
        }
        else{
            return Color.MAGENTA;
        }
    }
    
    //method to fight in critter simulation
    //returns scratch attack against an opponent
    //method takes a string parameter of the oppenent that will run into 
    //the husky in the simulation
    public Attack fight(String opponent){
        return Attack.SCRATCH;
    }

    //husky always returns a string of meef in the simulation
    public String toString(){
        return "meef";
    }

    //method for the husky to eat
    //returns true to allow ant to always eat
    public boolean eat(){
        return true;
    }
    
    //method returns a diretion moving west
    //method to get the directional movement of the husky
    public Direction getMove(){
        return Direction.WEST;
        }
    }
