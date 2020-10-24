import java.awt.*;
public class CafeWallOO{
    public static final int MORTAR = 2;

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();
        
        CafeWallRow row = new CafeWallRow(g, 20,4);
        row.DrawRow(0,0);

        CafeWallRow row2 = new CafeWallRow(g, 30, 5);
        row2.DrawRow(50,70);

        CafeWallRow r1 = new CafeWallRow(g,35,2);
        CafeWallGrid g1 = new CafeWallGrid(g, 35, r1);
        g1.DrawGrid(400,20);


        CafeWallRow r2 = new CafeWallRow(g, 25,4);
        CafeWallGrid g2 = new CafeWallGrid(g, 0, r2);
        g2.DrawGrid(10,150);

        CafeWallRow r3 = new CafeWallRow(g, 25,3);
        CafeWallGrid g3 = new CafeWallGrid(g, 10, r3);
        g3.DrawGrid(250,200);

        CafeWallRow r4 = new CafeWallRow(g, 20,5);
        CafeWallGrid g4 = new CafeWallGrid(g, 10, 3, r4);
        g4.DrawGrid(425,180);
        int x = 0;
        int y = 0;
        
        Sleep(2000);
        panel.clear();
        g4.DrawGrid(250,180);
        for (int j = 0 ;j <250;j++)
        {
            //int k = j % 4;
            int k = 3;
            if (k==3){
                g4.DrawGrid(x,y);
            }
            else if (k ==2){
                g3.DrawGrid(x,y);
            }
            else if (k==1){
                g2.DrawGrid(x,y);
            }
            else {
                g1.DrawGrid(x,y);
            }
            x +=2;
            y +=2;
            Sleep(50);
            panel.clear();
            if (y > 400 ){
                y = 0;
            }
        }
        
    }
    private static void Sleep(long milliseconds)
    {
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}

