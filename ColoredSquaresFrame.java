import javax.swing.*;
import java.awt.*;

public class ColoredSquaresFrame extends JFrame {

    private static final int numRows = 10;
    private static final int numCols = 10;
    private static final int squareSize = 50;

    private static final int[][] coloredSquareCoordinates = {
            {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {6, 4}, {6, 5},
            {7, 4}, {7, 5}
    };

    public ColoredSquaresFrame() {
        setTitle("Colored Squares JFrame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawColoredSquares(g);
            }
        };

        getContentPane().add(panel);

        setVisible(true);
    }

    private void drawColoredSquares(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int startX = (getWidth() - numCols * squareSize) / 2;
        int startY = (getHeight() - numRows * squareSize) / 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int x = startX + j * squareSize;
                int y = startY + i * squareSize;

                // Check if the current square is at a colored coordinate
                boolean isColored = false;
                for (int[] coord : coloredSquareCoordinates) {
                    if (j == coord[0] && i == coord[1]) {
                        isColored = true;
                        break;
                    }
                }

                // Draw black outline
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, squareSize, squareSize);

                // Fill with appropriate color
                if (isColored) {
                    g2d.setColor(Color.BLUE); // Change this to your desired color
                } else {
                    g2d.setColor(Color.GREEN);
                }
                g2d.fillRect(x + 1, y + 1, squareSize - 1, squareSize - 1); // Offset to avoid overlapping with the outline
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColoredSquaresFrame());
    }
}
