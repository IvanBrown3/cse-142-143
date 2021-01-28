import java.util.*;

public class AssassinManager {
    private AssassinNode front;
    private AssassinNode frontG;

    public AssassinManager(List<String> names){
        if(front == null){
            throw new IllegalArgumentException();
        }
        front = new AssassinNode(names.get(0));
        AssassinNode current = front;
        for(int i = 1; i < names.size(); i++){
            current.next = new AssassinNode(names.get(i));
            current = current.next;
        }
    }

    public void printKillRing(){
        AssassinNode current = front;
        while(current.next != null){
            System.out.println("    " + current.name + " is stalking " + current.next.name);
            current = current.next;
        }
        System.out.println("    " + current.name + " is stalking " + front.name);
    }

    public void printGraveyard(){

    }

    public boolean killRingContains(String name){
        AssassinNode current = front;
        String theName = current.name.toLowerCase();
        while(current != null){
            if(theName.equalsIgnoreCase(name)){
                current = current.next;
                return true;
            }
                return false;
            }
        }

    }

    public boolean graveyardContains(String name){

    }

    public boolean gameOver(){

    }

    public String winner(){

    }


    public void kill(String name){

    }

}
