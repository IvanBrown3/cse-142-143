import java.util.*;

public class Rearrange {
    public static void rearrange(Queue<Integer> q) {
        Queue<Integer> aux = new LinkedList<Integer>();
        int s = q.size();
        for(int i = 0; i < s; i++){
            int val = q.remove();
            if(val % 2 == 0){
                q.add(val);
            }
            else{
                aux.add(val);
            }
        }
        int a = aux.size();
        for(int i = 0; i < a; i++){
            q.add(aux.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(3);
        q.add(5);
        q.add(4);
        q.add(17);
        q.add(6);
        q.add(8);
        rearrange(q);
        System.out.println(q);
    }
}