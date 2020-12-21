//Ivan Brown
//TA: CC Sent
//12/7/20
//This program is the functional class.
//When a vulture is created in the critter simulation. 
//The vulture class is always black, only eats when hungry and after a fight. 
//Vulture will roar on ants otherwise pounce. 

import java.awt.*;

//vulture class that extends the bird class since they share get Direction and get String from bird
//boolean field created for hunger
public class Vulture  extends Bird{
    private boolean hunger;

    //hunger is intially set to true since the vulture object is created hungry
    public Vulture(){
        hunger = true;
    }

    //vulture will eat if hungry and returns true
    //after each time eating the hunger is set to false since the vulture is only hungry once
    //if the vulture is not hungry, method to eat will return boolean as false
    public boolean eat(){
        if(hunger){
            hunger = false;
            return true;
        }
        else{
            return false;
        }
    }

    //method to set color of the vulture
    //returns the color to always be black
    public Color getColor(){
        return Color.BLACK;
    }

    //method to fight an opponent in simulation
    //takes a string of the opponent as a parameter
    //each time a fight occurs the vulture is hungry after if it wins
    //vulture will return roar in a fight against an ant
    //vulture will return a pounce for any other opponent
    public Attack fight(String opponent){
        hunger = true;
    }
}
