import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class board {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Stratego Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new StrategoPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

/*
class StrategoPanel extends JPanel {

    private static final int BOARD_SIZE = 10;
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public StrategoPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        initializeBoard();
        addMouseListener(new StrategoMouseListener());
    }

    private void initializeBoard() {
        // Initialize the board with placeholder values (you can replace this with your own logic)
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int squareSize = getWidth() / BOARD_SIZE;

        // Draw the game board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                g.setColor(Color.WHITE);
                g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }

        // Draw pieces or any other elements based on the board state
        // You can customize this part based on your game logic and piece representation
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    g.setColor(Color.RED);
                    g.fillOval(j * squareSize, i * squareSize, squareSize, squareSize);
                }
                // Add more conditions for other pieces/colors
            }
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
*/