import java.util.*;

public class AssassinManager {
    private AssassinNode assassins;
    private AssassinNode graveyard;

    public AssassinManager(List<String> names){
        if(names == null){
            throw new IllegalArgumentException();
        }

        AssassinNode previous = assassins;
        for(int i = 0; i < names.size(); i++){
            AssassinNode newAssassin  = new AssassinNode(names.get(i));
            if (assassins == null){
                assassins = newAssassin;
            } else {
                previous.next = newAssassin;
            }
            previous = newAssassin;
        }
    }

    public void printKillRing(){
        AssassinNode current = assassins;
        while (current != null){
            if (current.next != null){
                System.out.println("    " + current.name + " is stalking " + current.next.name);
            }
            else {
                System.out.println("    " + current.name + " is stalking " + assassins.name);
            }
            current = current.next;
        }
    }

    public void printGraveyard(){
        AssassinNode current = graveyard;
        while(current != null){
            System.out.println("    " + current.name + " was killed by " + current.killer);
            current = current.next;
        }
    }

    public boolean killRingContains(String name){
        return listContains(assassins, name);
    }

    public boolean graveyardContains(String name){
        return listContains(graveyard, name);
    }
    
    public boolean gameOver(){
        return assassins.next == null;
    }

    public String winner(){
        if(gameOver()){
            return assassins.name;
        }
        return null;
    }
    
    public void kill(String name){
        if (gameOver()){
            throw new IllegalStateException("Game already over");
        }
        AssassinNode current = assassins;
        AssassinNode prev = current;
        while(current != null && !current.name.equalsIgnoreCase(name)){
            prev = current;
            current = current.next;
        }
        if (current == null){
            throw new IllegalArgumentException("Killer not found");
        }
        else {
            // we found the victim
            if (assassins == current){
                //need to find the killer at the end of the list
                //since this is the first assassin in the list
                while(prev.next != null){ 
                    prev = prev.next; 
                }
            }
            //Killer is the prev.name
            current.killer = prev.name;

            //add current to the graveyard
            AssassinNode tmp = current.next;
            current.next = graveyard;
            graveyard = current;
            
            //remove the victim from the assassins list
            if (assassins == current){
                // set the assassins list to tmp 
                // since the victim was the first assassin in the list.
                assassins = tmp;
            }
            else{
                //advance past removed assassin
                prev.next = tmp;
            }
        }
    }

    private boolean listContains(AssassinNode list, String name){
        AssassinNode current = list;
        
        while(current != null){
            if(current.name.equalsIgnoreCase(name)){
                return true;
            }
            current = current.next;
        }

        return false;
    }
}
