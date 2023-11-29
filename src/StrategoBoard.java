import java.awt.*;
import java.awt.image.BufferedImage;
import Pieces.StrategoPiece;

public class StrategoBoard {
   // private BufferedImage boardImage;
    private StrategoPiece[][] pieces;
    private StrategoPanel panel;

    // public StrategoBoard(BufferedImage boardImage, StrategoPiece[][] pieces) {
    public StrategoBoard(StrategoPiece[][] pieces, StrategoPanel panel) {
      //  this.boardImage = boardImage;
        this.pieces = pieces;
        this.panel = panel;
    }

    public void render(Graphics g) {
       // g.drawImage(boardImage, 0, 0, null);

        // Draw each piece on the board

        this.drawPiece(g, pieces[0][0]);
        this.drawPiece(g, pieces[1][1]);

        /*
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                StrategoPiece piece = pieces[i][j];

                g.drawImage(piece.getImage(), piece.getX(), piece.getY(), null);
            }
        }

        */
    }

    public void drawPiece(Graphics g, StrategoPiece piece){

        g.drawImage(piece.image.getScaledInstance((panel.getWidth() / StrategoPanel.BOARD_SIZE) - 20,
                (panel.getHeight() / StrategoPanel.BOARD_SIZE) - 20, Image.SCALE_SMOOTH), 
            (piece.x * (this.panel.getWidth() / StrategoPanel.BOARD_SIZE) + 10),
            (piece.y * (this.panel.getWidth() / StrategoPanel.BOARD_SIZE) + 5), null);

    }
}