package Pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class StrategoPiece {
    public int rank;
    public int x, y; // position on the board
    public BufferedImage image;
    public String color;
    public MoveStrategy moveStrategy;
    public Boolean isAlive = true;

    public BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}