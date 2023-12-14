package Pieces;

public class Lieutenant extends StrategoPiece{

    public Lieutenant(int rank, int x, int y, String color) {
        //String name = "Lieutenant";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }

}
