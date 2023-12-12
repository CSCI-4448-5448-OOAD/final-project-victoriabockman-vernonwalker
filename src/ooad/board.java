package ooad;
import javax.swing.*;


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
        frame.add(new StrategoPanel("Red"));
        frame.pack();
        frame.setVisible(true);
    }
}