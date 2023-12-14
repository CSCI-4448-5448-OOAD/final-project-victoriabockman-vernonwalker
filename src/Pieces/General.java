package Pieces;

public class General extends StrategoPiece{

    public General(int rank, int x, int y, String color) {
        //String name = "General";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }
}
