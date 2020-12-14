//Ivan Brown
//TA: CC Sent
//12/7/20
//This program is the functional class for when an ant is created in the critter simulation. 
//The ant class is red and always eats. The ant moves north east, and  in south east directions. 

import java.awt.*;

//extends the base class of a critter
//sets private fields for walkSouth and movement
public class Ant extends Critter{

    //fields
    private boolean walkSouth;
    private int movement;
    
    //ant consructor which takes a boolean variable of walkSouth as a parameter
    //this constructor sets walkSouth as true and the movement is intialized at zero
    public Ant(boolean walkSouth){
        this.walkSouth = walkSouth;
        movement = 0;
    }

    //this method returns the color of the ant
    //the color returned is red
    public Color getColor(){
        return Color.RED;
    }

    //this method returns the ability for the ant to attack when encountering a fight
    //the fight method returns scratch as the move the ant must use
    //method takes the string of the opponent that the ant will face
    public Attack fight(String opponent){
        return Attack.SCRATCH;
    }

    //ant always returns a string of a percent sign in the simulation
    public String toString(){
        return "%";
    }

    //method for the ant to eat
    //returns true to allow ant to always eat
    public boolean eat(){
        return true;
    }

    //method to allow ant to move
    //returns the direction the ant must travel based on if walkSouth is 
    //constructed as true or false
    //method returns the direction
    public Direction getMove(){
        Direction dir;
        //Move
        if(walkSouth){
            if(movement % 2 == 0){
               dir = Direction.SOUTH;
            }
            else{
               dir = Direction.EAST;
            }
        }
        else {
            if(movement % 2 == 0){
                dir = Direction.NORTH;
            }
            else{
                dir = Direction.EAST;
            }
        }
        movement++;
        return dir;
    }
}


