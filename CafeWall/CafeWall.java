import java.awt.*;
public class CafeWall{
   public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();
        
     
   }
   
   private drawBoxPairs(Graphics g, int posX, int posY,int size, int pairs){
   // for loop
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 20, 20);
      g.drawLine(0, 0, 20, 20);
   // drawBlack
   // drawWhite
   
   }
   private drawBlackBox(int posX, int posY, int size)
   {
      g.drawRect(
   }
   private drawWhiteBox(int posX, int posY, int size)
   {
   }
   
}

//need to know: starting x, starting y, box pairs, box size 