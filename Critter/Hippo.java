//Ivan Brown
//TA: CC Sent
//12/7/20
//This program is the functional class.
//When a hippo is created in the critter simulation. 
//The hippo class is gray when hungry and white when not. 
//Scratches when not hungry and pounces when hungry. 
//This hippo will apear
//as its hunger level in the simulation and will update after each time eating.
//Moves 5 times in a random direction

import java.awt.*;
import java.util.*;

//this is the class that gives the behavior of the hippo
//field created for a random number
//hippo extends the base class of the critter
//field crated for hunger
//field created for movement
//field created for random object to be made
//field for the direction 
public class Hippo extends Critter{
    private int randomNum; 
    private int hunger;
    private int movement;
    private Random rand;
    private Direction direction;
    
    //constructor for the hippo
    //movement set to zero
    //hunger is set to itself to keep the boolean statement neutral
    public Hippo(int hunger){
        movement = 0;
        this.hunger = hunger;
    }

    //method to get the color of the hippo
    //returns the color of gray when the hippo is hungry 
    //returns white if the hippo is not hungry
    public Color getColor(){
        if(hunger > 0){
            return Color.GRAY;
        }
        return Color.WHITE;
    }

    //method to let the hippo fight
    //returns scratch when hungry
    //reutrns pounce if not hungry
    //takes a string of the opponent that the hippo will face in battle
    public Attack fight(String opponent){
        if(hunger > 0){
            return Attack.SCRATCH;
        }
        else{
            return Attack.POUNCE;
        }
    }

    //method to return the string of the hippo in the simulation
    //returns the string of the hunger of the hippo
    public String toString(){
        String string = Integer.toString(hunger); 
        return string;
    }

    //method to allow hippo to move
    //moves randomly in a direction 5 times
    //returns 5 moves in the direction randomly based on the setDirection method
    public Direction getMove(){
        if (movement % 5 == 0) {
            setDirection();
        }
        movement++;
        return direction;
    }

    //method to set the direction that the hippo will randomly pick
    //private method to functionally remain in this class
    //random object created that creates a value of 4 numbers 0-3 inclusive 
    private void setDirection() {
        rand = new Random();
        randomNum = rand.nextInt(4);
        if(randomNum == 0){
            direction = Direction.NORTH;
        }
        else if(randomNum == 1){
            direction = Direction.SOUTH;
        }
        else if(randomNum == 2){
            direction = Direction.EAST;
        }
        else{
            direction = Direction.WEST;
        }
    }

    //method to eat 
    //returns true to eat if hungry
    //returns false otherwise
    public boolean eat(){
        if(hunger > 0){
            hunger--;
            return true;
        }
        else {
            return false;
        }   
    }
}
