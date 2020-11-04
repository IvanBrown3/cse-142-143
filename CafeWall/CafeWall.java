//Ivan Brown
//10/20/20
//TA: CC Sent
//This program will produce a cafe wall image using drawingpanel.
//This image will create rows and grids of black and white boxes
//of different sizes in different positions.
//Grids will have pixel spaces between the rows called a MOTAR.
import java.awt.*;
public class CafeWall{
    public static final int MORTAR = 2;
    //passes the parameters to draw rows and grids 
    //in the correct size, positon and amount of black and white pairs
    //Grids will be based on row pairs instead of box pairs
    //Grids will also have an offest value and MOTAR
    //MOTAR is the pixel spacing between rows in the grids

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
    //method draws a grid which consists of rows
    //passes the graphics brush to draw
    //initial x and y positions of the box
    //inital size 
    //gives offset of the grids 

    public static void drawGrid(Graphics g, int posX, int posY, int pairs, int size, int offset) {
        for(int pair = 0; pair < pairs; pair++){
            drawRow(g, posX, posY, pairs, size);
            posY += size + MORTAR;
            drawRow(g, posX + offset, posY, pairs, size);
            posY += size + MORTAR;
        }
    }

    //method draws a row
    //passes graphics brush
    //passes x and why position of the boxes that create the rows
    //passes the amount of box pairs of white and black boxes
    //passes size of the boxes

    public static void drawRow(Graphics g, int posX, int posY, int pairs, int size) {
        for(int pair = 0; pair < pairs; pair++){
            drawBlackBox(g, posX, posY, size);
            posX += size;
            drawBox(g, posX, posY, size, Color.WHITE); 
            posX += size;
        }
    }
    //draws a black box
    //passes the graphics brush 
    //passes x and y position 
    //passes black box size
    
    public static void drawBlackBox(Graphics g, int posX, int posY, int size) {
        drawBox(g,posX,posY,size,Color.BLACK);
        g.setColor(Color.BLUE);
        g.drawLine(posX, posY, posX + size, posY + size);
        g.drawLine(posX, posY + size, posX + size, posY);
        
    }
    //method to draw a singular box and make a set color
    //passes the graphics, x and y position, size
    //passes parameter to be able to set the color 

    public static void drawBox(Graphics g, int x, int y, int size, Color c ){
        g.setColor(c);
        g.fillRect(x,y, size, size);
    }
}

