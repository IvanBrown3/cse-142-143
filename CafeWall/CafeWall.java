import java.awt.*;
public class CafeWall{
    public static final int MORTAR = 2;

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();
        drawRow(g, 0,0, 4,20);
        drawRow(g, 50,70, 5,30);

        drawGrid(g, 400, 20, 2, 35, 35);
        drawGrid(g, 10 ,150, 4, 25, 0);
        drawGrid(g, 250, 200, 3, 25, 10);
        drawGrid(g, 425, 180, 5, 20, 10);
        
    }

    public static void drawGrid(Graphics g, int posX, int posY, int pairs, int size, int offset) {
        for(int pair = 0; pair < pairs; pair++){
            drawRow(g, posX, posY, pairs, size);
            posY+=size+MORTAR;
            drawRow(g, posX + offset, posY, pairs, size);
            posY+=size + MORTAR;
        }
    }

    public static void drawRow(Graphics g, int posX, int posY, int pairs, int size) {
        for(int pair = 0; pair < pairs; pair++){
            drawBlackBox(g, posX, posY, size);
            posX+=size;
            drawWhiteBox(g, posX, posY, size);
            posX+=size;
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

