package Pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Move.MoveStrategy;

public abstract class StrategoPiece {
    public int rank;
    public int x, y; // position on the board
    public BufferedImage image;
    public String color;
    public MoveStrategy moveStrategy;

    public BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
    public StrategoPiece(int rank, int x, int y, BufferedImage image) {
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getRank() {
        return rank;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImage() {
        return image;
    }
    */
}