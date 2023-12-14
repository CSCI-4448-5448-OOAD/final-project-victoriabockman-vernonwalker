package Pieces;

public class Captain extends StrategoPiece{

    public Captain(int rank, int x, int y, String color) {
        //String name = "Captain";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }

}
