package Pieces;

public class Sergeant extends StrategoPiece{

    public Sergeant(int rank, int x, int y, String color) {
        //String name = "Sergeant";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }

}
