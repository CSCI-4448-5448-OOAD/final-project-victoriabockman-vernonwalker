package ooad;
import java.awt.BorderLayout;

import javax.swing.*;


public class board {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        StrategoPanel panel = new StrategoPanel("Red");
        StrategoFrame frame = new StrategoFrame(panel, "Stratego Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 1050);
    }
}