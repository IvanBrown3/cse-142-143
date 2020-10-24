import java.awt.*;

public class Doodle{
    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(400, 400);
        panel.setBackground(Color.WHITE);
        Graphics g = panel.getGraphics();

        g.setColor(Color.BLUE);
        g.fillRect(180, 200, 55, 45);

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(360, 20, 40, 40);

        g.setColor(Color.GREEN);
        g.fillRoundRect(30, 40, 100, 200, 50, 50);
    }
}