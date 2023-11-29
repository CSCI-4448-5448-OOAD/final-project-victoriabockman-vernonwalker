package Pieces;


public class Major extends StrategoPiece{

    public Major(int rank, int x, int y, String color) {
        String name = "Major";
        this.rank = rank;
        this.x = x;
        this.y = y;
        this.color = color;

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
