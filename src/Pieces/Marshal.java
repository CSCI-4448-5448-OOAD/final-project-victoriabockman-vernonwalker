package Pieces;

public class Marshal extends StrategoPiece{

    public Marshal(int rank, int x, int y, String color) {
        //String name = "Marshal";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }
}
