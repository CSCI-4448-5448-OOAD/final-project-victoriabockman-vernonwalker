package Pieces;

public class Spy extends StrategoPiece{

    public Spy(int rank, int x, int y, String color) {
        //String name = "Spy";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }
}
