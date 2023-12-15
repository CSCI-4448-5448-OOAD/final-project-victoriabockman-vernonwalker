package ooad;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Pieces.StrategoPiece;

public class Square extends JComponent{
    // stores which square this is using coordinates
    public int xNum;
    public int yNum;
    private StrategoPanel pan;
    // the piece currently in this square
    public StrategoPiece occupyingPiece;
    // constant for the size of this component when rendered
    private int squareSize;
    // private int xPos;
    // private int yPos;
    // private int size;

    // the color of this square
    private final int color;

    public Square(int x, int y, int c, StrategoPanel p, int sq){
        this.xNum = x;
        this.yNum = y;
        this.color = c;
        this.pan = p;
        this.squareSize = sq;
        this.setLocation(x * sq, y * sq);
        this.setSize(sq, sq);
    }

    // how to render this object
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

        // draw the occupying piece if this has one
        if(this.occupyingPiece != null){
            this.drawPiece(g, this.getPiece());
        }

        // System.out.println("X: " + this.getX() + " Y: " + this.getY());
        // System.out.println("Width: " + this.getWidth() + " Height: " + this.getHeight());
        // System.out.println("Superclass Squaresize: " + this.squareSize);
        
    }

    // getter
    public StrategoPiece getPiece(){
        return this.occupyingPiece;
    }

    // setter
    public void setPiece(StrategoPiece p){
        this.occupyingPiece = p;
    }




    // load the image of the appropriate piece
    BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // draw the piece
    public void drawPiece(Graphics g, StrategoPiece piece){

        Image piece_image = getPieceImage(piece);

        g.drawImage(piece_image.getScaledInstance((this.squareSize) - 20,
                (this.squareSize) - 20, Image.SCALE_SMOOTH), 
                (piece.x * (this.squareSize) + 10),
                (piece.y * (this.squareSize) + 5), null);

    }


    // get the piece image from the file name
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
                end = "SPY-min.png";
                break;

            case 2:
                end = "SCOUT-min.png";
                break;

            case 3:
                end = "MINER-min.png";
                break;

            case 4:
                end = "SERGEANT-min.png";
                break;

            case 5:
                end = "LIEUTENANT-min.png";
                break;

            case 6:
                end = "CAPTAIN-min.png";
                break;

            case 7:
                end = "MAJOR-min.png";
                break;

            case 8:
                end = "COLONEL-min.png";
                break;

            case 9:
                end = "GENERAL-min.png";
                break;

            case 10:
                end = "MARSHAL-min.png";
                break;
            
            case 0:
                end = "FLAG-min.png";
                break;

            case 11:
                end = "BOMB-min.png";
                break;
        
            default:
                break;
        }

        String img_name = col + end;

        // Image image = this.loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/"
        // + img_name);

        // System.out.println("\n" + Paths.get("").toAbsolutePath().toString() + "/src/Stratego/" + img_name + "\n");

        Image image = this.loadImage(Paths.get("").toAbsolutePath().toString() + "/src/Stratego/" + img_name);

        return image;
    }

    public int getColor(){
        return this.color;
    }

}
