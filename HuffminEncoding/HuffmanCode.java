import java.util.*;
import java.io.*;

public class HuffmanCode {
    private HuffmanNode overallRoot  = null;


    public HuffmanCode(int[] frequencies){
        Queue<HuffmanNode> pq = new PriorityQueue<>();
        for(int i = 0; i < frequencies.length; i++){
            if (frequencies[i] > 0){
                HuffmanNode node = new HuffmanNode(frequencies[i], i);
                pq.add(node);
            }
        }
        while(pq.size() > 1){
            HuffmanNode left = pq.remove();
            HuffmanNode right = pq.remove();
            HuffmanNode head = new HuffmanNode(left.frequency + right.frequency, -1, left, right);
            pq.add(head);
        }
        //after we remove pq should be empty
        overallRoot = pq.remove();
    }

    public HuffmanCode(Scanner input){
        overallRoot = new HuffmanNode(0, -1);
        while(input.hasNextLine()){
            int ascii = Integer.parseInt(input.nextLine());
            String binary = input.nextLine();
            buildTree(ascii, binary);
        }
    }

    private void buildTree(int ascii, String binary) {
        HuffmanNode root = overallRoot;
        for(int i = 0; i < binary.length(); i++){
            char bit = binary.charAt(i);
            HuffmanNode n;
            if(i == binary.length() - 1){
                n = new HuffmanNode(0, ascii);
            }else{
                n = new HuffmanNode(0, -1);
            }
            if(bit == '0'){
                if(root.left == null){
                    root.left = n;
                }
                root = root.left;
            } else{
                if(root.right == null){
                    root.right = n;
                }
                root = root.right;
                
            }
        }
    }

    public void save(PrintStream output){
        String buffer = "";
        outputTree(overallRoot.left, "0", output);
        outputTree(overallRoot.right, "1", output);
    }

    private void outputTree(HuffmanNode n, String buffer, PrintStream output){
        if(n == null){
            return;
        }
        if(n.left == null && n.right ==null){
            output.println(n.acsiiCode);
            output.println(buffer);
        }else{
            outputTree(n.left, buffer + "0", output);
            outputTree(n.right, buffer + "1", output);
        }
    } 

    public void translate(BitInputStream input, PrintStream output){
        while(input.hasNextBit()){
            searchTree(overallRoot, input, output);
        }
    }
    private void searchTree(HuffmanNode n, BitInputStream input, PrintStream output){
        if(n == null){
            return;
        }
        if(n.left == null && n.right ==null){
            output.print((char)n.acsiiCode);
            return;
        }   
        int bit = input.nextBit();
        if (bit == 0){
            searchTree(n.left, input, output);
        }
        else{
            searchTree(n.right, input, output);
        }
    }
}
