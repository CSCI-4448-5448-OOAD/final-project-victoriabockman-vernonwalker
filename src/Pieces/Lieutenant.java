package Pieces;

import java.awt.image.BufferedImage;

public class Lieutenant extends StrategoPiece{

    public Lieutenant(int rank, int x, int y, String color) {
        String name = "Lieutenant";
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
