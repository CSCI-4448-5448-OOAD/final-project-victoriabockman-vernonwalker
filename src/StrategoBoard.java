import java.awt.*;
import java.awt.image.BufferedImage;

public class StrategoBoard {
   // private BufferedImage boardImage;
    private StrategoPiece[][] pieces;

    // public StrategoBoard(BufferedImage boardImage, StrategoPiece[][] pieces) {
    public StrategoBoard(StrategoPiece[][] pieces) {
      //  this.boardImage = boardImage;
        this.pieces = pieces;
    }

    public void render(Graphics g) {
       // g.drawImage(boardImage, 0, 0, null);

        // Draw each piece on the board

        g.drawImage(pieces[0][0].getImage(), pieces[0][0].getX(), pieces[0][0].getY(), null);
        g.drawImage(pieces[1][1].getImage(), pieces[1][1].getX(), pieces[1][1].getY(), null);

        /*
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                StrategoPiece piece = pieces[i][j];

                g.drawImage(piece.getImage(), piece.getX(), piece.getY(), null);
            }
        }

        */
    }
}