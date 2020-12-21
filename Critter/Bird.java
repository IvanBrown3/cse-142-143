//Ivan Brown
//TA: CC Sent
//12/7/20
//This program is the functional class.
//When a bird is created in the critter simulation. The bird class
//is always blue and moves in a clowckwise box starting north. 
//A new string is returned after each new direction 
//the bird travels in. The bird never eats. 
//The bird roars at ants and pounces otherwise. 

import java.awt.*;

//bird class that extends the base critter class
//crates field of integer for movement
public class Bird extends Critter{
    private  int movement;

    //method for bird constructor
    //sets movement to 0 intialialy
    public Bird(){
        movement = 0;
    }

    //method to get the color of the bird
    //bird will always return blue
    public Color getColor(){
        return Color.BLUE;
    }

    //method that allows the bird to fight
    //returns a roar if an ant is seen
    //takes a string of the opponent the bird will face
    //returns a pounce if the animal is not an ant
    public Attack fight(String opponent){
        if (opponent.equals("%")){  
            return Attack.ROAR;
        } else {
            return Attack.POUNCE;
        }
    }

    //method to get the string of the critter 
    //returns a new string based on the last move made
    //returns carot after each move north
    //returns greater than sign each move east
    //returns V each move south
    //returns less than sign each move west
    public String toString(){
        if(movement <= 3){
            return "^";
        }
        else if(movement <= 6){
            return ">";
        }
        else if(movement <= 9){
            return "V";
        }
        else{
            return "<";
        }
    }

    //method to move the critter in a direction
    //returns direction north the first 3 moves
    //returns direction east second 3 moves
    //returns direction south third 3 moves
    //returns driection west last 3 moves
    //movement is set to 1 after 12 moves
    public Direction getMove(){
        movement++;
        if(movement > 12){
            movement = 1;
        }
        if (movement <= 3) {        
            return Direction.NORTH;
        } else if (movement <= 6) { 
            return Direction.EAST;
        } else if(movement <= 9){                 
            return Direction.SOUTH;
        }
        else{
            return Direction.WEST;
        }
    }
}

