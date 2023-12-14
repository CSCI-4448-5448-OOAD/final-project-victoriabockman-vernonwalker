package Pieces;

public class Major extends StrategoPiece{

    public Major(int rank, int x, int y, String color) {
        //String name = "Major";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }
}
