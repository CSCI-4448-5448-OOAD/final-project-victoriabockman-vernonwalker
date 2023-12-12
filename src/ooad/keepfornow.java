package ooad;
import java.awt.*;
import java.awt.image.BufferedImage;
import Pieces.StrategoPiece;

import java.nio.file.Path;
import java.nio.file.Paths;

public class keepfornow {
   // private BufferedImage boardImage;
    private StrategoPiece[][] pieces;
    private StrategoPanel panel;
    private Square[][] boardSquares;

    // public StrategoBoard(BufferedImage boardImage, StrategoPiece[][] pieces) {
    public keepfornow(StrategoPiece[][] pieces, StrategoPanel panel) {
      //  this.boardImage = boardImage;
        this.pieces = pieces;
        this.panel = panel;
    }

    public void render(Graphics g) {
       // g.drawImage(boardImage, 0, 0, null);

        // Draw each piece on the board


        
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {

                if(pieces[i][j] != null){

                    this.drawPiece(g, pieces[i][j]);

                }
            }
        }

        
    }

    public void drawPiece(Graphics g, StrategoPiece piece){

        Image piece_image = getPieceImage(piece);

        g.drawImage(piece_image.getScaledInstance((panel.getWidth() / StrategoPanel.BOARD_SIZE) - 20,
                (panel.getHeight() / StrategoPanel.BOARD_SIZE) - 20, Image.SCALE_SMOOTH), 
            (piece.x * (this.panel.getWidth() / StrategoPanel.BOARD_SIZE) + 10),
            (piece.y * (this.panel.getWidth() / StrategoPanel.BOARD_SIZE) + 5), null);

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

            case 11:
                end = "BOMB.png";
                break;
        
            default:
                break;
        }

        String img_name = col + end;

        Image image = this.panel.loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/"
        + img_name);

        Image image2 = this.panel.loadImage("\\Users\\bockm\\Desktop\\OOAD (4448)\\Final_project\\final-project-victoriabockman\\src\\Stratego\\" + img_name);

        // return image;
        return image2;
    }
}