import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Pieces.PieceFactory;
import Pieces.StrategoPiece;

public class StrategoPanel extends JPanel {

    public static final int BOARD_SIZE = 10;
    private StrategoBoard strategoBoard;

    public StrategoPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        System.out.println("here");
        initializeBoard();
        addMouseListener(new StrategoMouseListener());
    }

    private void initializeBoard() {
        // Load board and piece images
       // BufferedImage boardImage = loadImage("C:\\\\Users\\bockm\\Pictures\\Stratego\\board.png");

       // Image bombImage = loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/bomb.png");
       // Image spyImage = loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/spy.png");

        System.out.println("loaded");

        // Create a 10x10 board with initial piece placement
        StrategoPiece[][] initialPieces = new StrategoPiece[10][10];
        initialPieces[0][0] = PieceFactory.createPiece(6, 0, 0, "Red");
        initialPieces[0][1] = PieceFactory.createPiece(1, 0, 1, "Red");
        initialPieces[0][2] = PieceFactory.createPiece(10, 0, 2, "Red");
        initialPieces[5][3] = PieceFactory.createPiece(0, 5, 3, "Red");

        initialPieces[9][5] = PieceFactory.createPiece(5, 9, 5, "Blue");
        initialPieces[9][3] = PieceFactory.createPiece(-1, 9, 3, "Blue");
        initialPieces[5][5] = PieceFactory.createPiece(2, 5, 5, "Blue");
        initialPieces[1][1] = PieceFactory.createPiece(3, 1, 1, "Blue");

        // Need to add more pieces...

        // Create the Stratego board
       // strategoBoard = new StrategoBoard(boardImage, initialPieces);
          strategoBoard = new StrategoBoard(initialPieces, this);
    }

    public Dimension getPreferredSize() {
        // Size of board
        return new Dimension(900, 1000);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int squareSize = getWidth() / BOARD_SIZE;

        // Draw the game board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                g.setColor(Color.lightGray);
                g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }

        // DO I NEED TO FILL THE PICS HERE????

        g.setColor(Color.BLUE);

        // Fill left lake
        g.fillRect(2 * squareSize, 5 * squareSize, squareSize, squareSize);
        g.fillRect(2 * squareSize, 4 * squareSize, squareSize, squareSize);
        g.fillRect(3 * squareSize, 5 * squareSize, squareSize, squareSize);
        g.fillRect(3 * squareSize, 4 * squareSize, squareSize, squareSize);

        // Fill right lake
        g.fillRect(6 * squareSize, 5 * squareSize, squareSize, squareSize);
        g.fillRect(6 * squareSize, 4 * squareSize, squareSize, squareSize);
        g.fillRect(7 * squareSize, 5 * squareSize, squareSize, squareSize);
        g.fillRect(7 * squareSize, 4 * squareSize, squareSize, squareSize);


        strategoBoard.render(g);
    }

    BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class StrategoMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int row = e.getY() / (getHeight() / BOARD_SIZE);
            int col = e.getX() / (getWidth() / BOARD_SIZE);

            // Handle mouse click, update the board state, and repaint
            // You can implement your game logic here

            repaint(); // what does this do?
        }
    }
}