import java.awt.*;

public class StrategoPiece {
    private int rank;
    private int x, y; // position on the board
    private Image image;

    public StrategoPiece(int rank, int x, int y, Image image) {
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

    public Image getImage() {
        return image;
    }
}