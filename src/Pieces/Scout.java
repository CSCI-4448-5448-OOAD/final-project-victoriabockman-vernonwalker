package Pieces;

public class Scout extends StrategoPiece{

    public Scout(int rank, int x, int y, String color) {
        //String name = "Scout";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new ScoutMove();

    }

}
