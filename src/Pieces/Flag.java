package Pieces;

public class Flag extends StrategoPiece{

    public Flag(int rank, int x, int y, String color) {
        String name = "Flag";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;
        this.moveStrategy = new NoMove();

        if(color == "Red"){
            // load red image
            // this.image = loadImage("C:\\Users\\bockm\\Desktop\\OOAD (4448)\\Test - Java\\Stratego\\spy.png");
        }
        else if(color == "Blue"){
            // load blue image
        }
        else{
            System.out.println("error");
            this.image = null;
        }
    }
}
