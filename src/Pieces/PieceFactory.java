package Pieces;

import java.awt.image.BufferedImage;

public class PieceFactory {
    public static StrategoPiece createPiece(int rank, int x, int y, String color){
		if (rank == 1){
            return new Spy(rank, x, y, color);
            // Quantity: 1
        }
		if(rank == 2){
            return new Scout(rank, x, y, color);
            // Quantity: 8
        }
        else if(rank == 3){
            return new Miner(rank, x, y, color);
            // Quantity: 5
        }
        else if(rank == 4){
            return new Sergeant(rank, x, y, color);
            // Quantity: 4
        }
        else if(rank == 5){
            return new Lieutenant(rank, x, y, color);
            // Quantity: 4
        }
        else if(rank == 6){
            return new Captain(rank, x, y, color);
            // Quantity: 4
        }
        else if(rank == 7){
            return new Major(rank, x, y, color);
            // Quantity: 3
        }
        else if(rank == 8){
            return new Colonel(rank, x, y, color);
            // Quantity: 2
        }
        else if(rank == 9){
            return new General(rank, x, y, color);
            // Quantity: 1
        }
        else if(rank == 10){
            return new Marshal(rank, x, y, color);
            // Quantity: 1
        }

        // IMPORTANT: Flag rank is 0
        else if(rank == 0){
            return new Flag(rank, x, y, color);
            // Quantity: 1
        }

        // IMPORTANT: Bomb rank is -1
        else if(rank == 11){
            return new Bomb(rank, x, y, color);
            // Quantity: 6
        }
		else{
            System.out.println("error");
            return null;
        }
	}
}
