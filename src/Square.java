import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Pieces.StrategoPiece;

public class Square extends JComponent{
    private int xNum;
    private int yNum;
    private StrategoPanel pan;
    private StrategoPiece occupyingPiece;
    private int squareSize;
    // private int xPos;
    // private int yPos;
    // private int size;

    private final int color;

    public Square(int x, int y, int c, StrategoPanel p, int sq){
        this.xNum = x;
        this.yNum = y;
        this.color = c;
        this.pan = p;
        this.squareSize = sq;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (this.color == 1) {
            g.setColor(new Color(124,252,0));
        } else {
            g.setColor(new Color(0,157,196));
        }
        
        g.fillRect(this.xNum * squareSize, 
            this.yNum * squareSize, squareSize, squareSize);

        g.setColor(Color.black);

        g.drawRect(this.xNum * squareSize, 
            this.yNum * squareSize, squareSize, squareSize);

        this.drawPiece(g, this.getPiece());
        
    }

    public StrategoPiece getPiece(){
        return this.occupyingPiece;
    }

    public void setPiece(StrategoPiece p){
        this.occupyingPiece = p;
    }




    BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void drawPiece(Graphics g, StrategoPiece piece){

        Image piece_image = getPieceImage(piece);

        g.drawImage(piece_image.getScaledInstance((this.squareSize / StrategoPanel.BOARD_SIZE) - 20,
                (this.squareSize / StrategoPanel.BOARD_SIZE) - 20, Image.SCALE_SMOOTH), 
                (piece.x * (this.squareSize / StrategoPanel.BOARD_SIZE) + 10),
                (piece.y * (this.squareSize / StrategoPanel.BOARD_SIZE) + 5), null);

    }


    private Image getPieceImage(StrategoPiece piece){
        String col = "";
        String end = "";

        if(piece.color == "Red"){
            col = "RED_";
        }
        else{
            col = "BLUE_";
        }

        switch (piece.rank) {
            case 1:
                end = "SPY.png";
                break;

            case 2:
                end = "SCOUT.png";
                break;

            case 3:
                end = "MINER.png";
                break;

            case 4:
                end = "SERGEANT.png";
                break;

            case 5:
                end = "LIEUTENANT.png";
                break;

            case 6:
                end = "CAPTAIN.png";
                break;

            case 7:
                end = "MAJOR.png";
                break;

            case 8:
                end = "COLONEL.png";
                break;

            case 9:
                end = "GENERAL.png";
                break;

            case 10:
                end = "MARSHAL.png";
                break;
            
            case 0:
                end = "FLAG.png";
                break;

            case -1:
                end = "BOMB.png";
                break;
        
            default:
                break;
        }

        String img_name = col + end;

        Image image = this.loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/"
        + img_name);

        return image;
    }

}
