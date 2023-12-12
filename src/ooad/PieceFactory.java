package ooad;


import java.awt.image.BufferedImage;

import Pieces.Bomb;
import Pieces.Captain;
import Pieces.Colonel;
import Pieces.Flag;
import Pieces.General;
import Pieces.Lieutenant;
import Pieces.Major;
import Pieces.Marshal;
import Pieces.Miner;
import Pieces.Scout;
import Pieces.Sergeant;
import Pieces.Spy;
import Pieces.StrategoPiece;

public class PieceFactory {
    public static StrategoPiece createPiece(int rank, int x, int y, String color, Square start){

        StrategoPiece p = null;

		if (rank == 1){
            p = new Spy(rank, x, y, color);
            // Quantity: 1
        }
		else if(rank == 2){
            p = new Scout(rank, x, y, color);
            // Quantity: 8
        }
        else if(rank == 3){
            p = new Miner(rank, x, y, color);
            // Quantity: 5
        }
        else if(rank == 4){
            p = new Sergeant(rank, x, y, color);
            // Quantity: 4
        }
        else if(rank == 5){
            p = new Lieutenant(rank, x, y, color);
            // Quantity: 4
        }
        else if(rank == 6){
            p = new Captain(rank, x, y, color);
            // Quantity: 4
        }
        else if(rank == 7){
            p = new Major(rank, x, y, color);
            // Quantity: 3
        }
        else if(rank == 8){
            p = new Colonel(rank, x, y, color);
            // Quantity: 2
        }
        else if(rank == 9){
            p = new General(rank, x, y, color);
            // Quantity: 1
        }
        else if(rank == 10){
            p = new Marshal(rank, x, y, color);
            // Quantity: 1
        }

        // IMPORTANT: Flag rank is 0
        else if(rank == 0){
            p = new Flag(rank, x, y, color);
            // Quantity: 1
        }

        // IMPORTANT: Bomb rank is -1
        else if(rank == 11){
            p = new Bomb(rank, x, y, color);
            // Quantity: 6
        }
		else{
            System.out.println("error, no piece of this type:" + rank + "..");
            return null;
        }

        start.setPiece(p);
        return p;
	}
}
