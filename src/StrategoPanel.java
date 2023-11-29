import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StrategoPanel extends JPanel {

    private static final int BOARD_SIZE = 10;
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
        BufferedImage bombImage = loadImage("C:\\Users\\bockm\\Desktop\\OOAD (4448)\\Test - Java\\Stratego\\bomb.png");
        BufferedImage spyImage = loadImage("C:\\Users\\bockm\\Desktop\\OOAD (4448)\\Test - Java\\Stratego\\spy.png");

        System.out.println("loaded");

        // Create a 10x10 board with initial piece placement
        StrategoPiece[][] initialPieces = new StrategoPiece[10][10];
        initialPieces[0][0] = new StrategoPiece(6, 0, 0, bombImage);
        initialPieces[1][1] = new StrategoPiece(1, 1, 1, spyImage);
        // Need to add more pieces...

        // Create the Stratego board
       // strategoBoard = new StrategoBoard(boardImage, initialPieces);
          strategoBoard = new StrategoBoard(initialPieces);
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

    private BufferedImage loadImage(String path) {
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

            repaint();
        }
    }
}