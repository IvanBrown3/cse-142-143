import java.util.*;

public class Guitar37 implements Guitar {

    private GuitarString[] chords;
    private int time;

    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout

    public Guitar37(){
        chords = new GuitarString[KEYBOARD.length()];
        time = 0;
        for(int i = 0; i < KEYBOARD.length(); i++) {
            double freq = Math.pow(2, (i - 24.0) / 12.0) * 440.0;
            chords[i] = new GuitarString(freq);
        }
    }

    public boolean hasString(char c) {
        // if the char c is in the keyboard arrary return true
        return  KEYBOARD.indexOf(c) != -1 ;
    }

    public void playNote(int pitch) {
        //the pitch ranges between -24 and 12  
        //map the pitch to an idx by adding 24
        int idx = pitch + 24;  
        if (idx >= 0 && idx <= 37) {
            chords[idx].pluck();
        }
    }

    public double sample() {
        double sumofSample= 0.0;
        for (GuitarString guitarString : chords) {
            sumofSample += guitarString.sample();
        }
        return sumofSample;
    }

    public void tic() {
        for (GuitarString guitarString : chords) {
            guitarString.tic();
        }
        time++;
    }

    public int time() {
        return this.time;
    }

    public void pluck(char key) {
        if (this.hasString(key)) {
            this.chords[KEYBOARD.indexOf(key)].pluck();
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
