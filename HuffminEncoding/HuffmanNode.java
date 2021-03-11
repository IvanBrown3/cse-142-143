import java.util.*;

public class HuffmanNode implements Comparable<HuffmanNode> {
    public int frequency;
    public int acsiiCode;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(int frequency, int acsiiCode){
        this.frequency = frequency;
        this.acsiiCode = acsiiCode;
    }

    public HuffmanNode(int frequency, int acsiiCode, HuffmanNode left, HuffmanNode right){
        this.frequency = frequency;
        this.acsiiCode = acsiiCode;
        this.left = left;
        this.right = right;
    }

    public int compareTo(HuffmanNode other) {
        if (this.frequency < other.frequency) {
            return -1;
        } else if (this.frequency > other.frequency) {
            return 1;
        } else {
            return 0;
        }
    }
}
