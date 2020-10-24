import java.awt.*;
public class CafeWallGrid {
    public CafeWallRow CafeRow;
    public int RowPairs;
    public int Offset;
    public Graphics G;
    private final int MORTAR=2;

    public CafeWallGrid (Graphics g, int offset, CafeWallRow row){
        this.CafeRow = row;
        this.RowPairs = row.BoxPairs;
        this.Offset = offset;
    }

    public CafeWallGrid (Graphics g, int offset, int rowPairs, CafeWallRow row){
        this.CafeRow = row;
        this.RowPairs = rowPairs;
        this.Offset = offset;
    }

    public void DrawGrid(int posX, int posY){
        for(int pair = 0; pair < this.RowPairs; pair++){
            this.CafeRow.DrawRow(posX, posY);
            posY+=this.CafeRow.Size+MORTAR;
            this.CafeRow.DrawRow(posX + this.Offset, posY);
            posY+=this.CafeRow.Size + MORTAR;
        }
    }
}
