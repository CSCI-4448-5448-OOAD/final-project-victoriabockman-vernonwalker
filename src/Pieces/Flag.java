package Pieces;

public class Flag extends StrategoPiece{

    public Flag(int rank, int x, int y, String color) {
        //String name = "Flag";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NoMove();

    }
}
