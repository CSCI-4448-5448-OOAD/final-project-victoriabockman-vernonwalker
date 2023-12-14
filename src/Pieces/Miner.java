package Pieces;

public class Miner extends StrategoPiece{

    public Miner(int rank, int x, int y, String color) {
        //String name = "Miner";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NormalMove();

    }

}
