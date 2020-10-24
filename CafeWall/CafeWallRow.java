import java.awt.*;
public class CafeWallRow {

    public int Size;
    public int BoxPairs;
    public Graphics G;

    public CafeWallRow( Graphics g,int size,int boxPairs){
        this.Size = size;
        this.BoxPairs = boxPairs;
        this.G = g;
    }
    public void DrawRow(int posX, int posY)
    {
        for(int pair = 0; pair < this.BoxPairs; pair++){
            drawBlackBox(this.G, posX, posY, this.Size);
            posX+=this.Size;
            drawWhiteBox(this.G, posX, posY, this.Size);
            posX+=this.Size;
        }
    }

    private static void drawBlackBox(Graphics g, int posX, int posY, int size)
    {
        drawBox(g,posX,posY,size,Color.BLACK);
        g.setColor(Color.BLUE);
        g.drawLine(posX, posY, posX+size, posY+size);
        g.drawLine(posX, posY+size, posX+size, posY);
        
    }
    private static void drawWhiteBox(Graphics g, int posX, int posY, int size)
    {
        drawBox(g, posX, posY, size,Color.WHITE);      
    }
    private static void drawBox(Graphics g, int x, int y, int size, Color c ){
        g.setColor(c);
        g.drawRect(x, y, size, size);
        g.fillRect(x,y, size, size);
    }
}
