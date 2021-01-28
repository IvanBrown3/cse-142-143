import java.util.*;

public class GuitarString{
    private Queue<Double> ringBuffer; 
    private Random rand = new Random();
        
    public static final double DECAY_FACTOR = 0.996;
    
    public GuitarString(double frequency){
        int n = (int)(Math.round(StdAudio.SAMPLE_RATE / frequency));
        
        if(frequency <= 0 || n < 2 ){
            throw new IllegalArgumentException();
        }
        
        ringBuffer = new LinkedList<Double>();
        for (int i = 0; i < n; i++){
            ringBuffer.add(0.0);
        }
    }
    
    public GuitarString(double[] init){
        if(init.length < 2 ){
            throw new IllegalArgumentException();
        }

        ringBuffer = new LinkedList<Double>();
        for(int i = 0; i < init.length; i++){
            ringBuffer.add(init[i]);  
        }
    }

    private double generate(){
        // next double return 0.0 - 1.0
        return rand.nextDouble() - 0.5;
    }
    
    public void pluck(){
        for(int i = 0; i < ringBuffer.size(); i++){
            ringBuffer.remove();
            ringBuffer.add(this.generate());
        }
    }        
    
    public void tic(){
        double rem = ringBuffer.remove();
        double peek = ringBuffer.peek();
        double val = 0.5 * (rem + peek) * DECAY_FACTOR;
        ringBuffer.add(val);
    }
    
    public double sample(){
        return ringBuffer.peek();
    }
}



