import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import Pieces.StrategoPiece;

public class Square extends JComponent{
    private int xNum;
    private int yNum;
    private StrategoPanel pan;
    private StrategoPiece occupyingPiece;
    // private int xPos;
    // private int yPos;
    // private int size;

    private final int color;

    public Square(int x, int y, int c, StrategoPanel p){
        this.xNum = x;
        this.yNum = y;
        this.color = c;
        this.pan = p;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (this.color == 1) {
            g.setColor(new Color(124,252,0));
        } else {
            g.setColor(new Color(0,157,196));
        }
        
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        g.setColor(Color.black);

        g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        
    }

    public StrategoPiece getPiece(){
        return this.occupyingPiece;
    }

    public void setPiece(StrategoPiece p){
        this.occupyingPiece = p;
    }

}
