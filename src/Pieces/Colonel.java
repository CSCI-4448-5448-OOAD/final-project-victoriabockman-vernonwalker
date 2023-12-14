package Pieces;

public class Colonel extends StrategoPiece{

    public Colonel(int rank, int x, int y, String color) {
        //String name = "Colonel";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }
}
