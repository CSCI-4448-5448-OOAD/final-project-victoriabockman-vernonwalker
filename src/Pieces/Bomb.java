package Pieces;

public class Bomb extends StrategoPiece{

    public Bomb(int rank, int x, int y, String color) {
        //String name = "Bomb";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NoMove();

    }
}
