package Pieces;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ooad.StrategoPanel;

public class NormalMove implements MoveStrategy{
    
    @Override
    public List<Point> legalMoves(StrategoPiece strategoPiece, StrategoPanel board){

        List<Point> list = new ArrayList<>();

        int x = strategoPiece.x;
        int y = strategoPiece.y;
        String color = strategoPiece.color;

        int x_left = x - 1;
        int x_right = x + 1;

        int y_up = y - 1;
        int y_down = y + 1;


        // ADD the four possible moves to the list, if they exist within bounds

        // Lake 1:

        // left side
        if(x == 1){
            if(y == 4){
                x_right = -1;
            }
            else if(y == 5){
                x_right = -1;
            }
            else{
                // do nothing
            }
        }

        // right side
        if(x == 4){
            if(y == 4){
                x_left = -1;
            }
            else if(y == 5){
                x_left = -1;
            }
            else{
                // do nothing
            }
        }
        
        // above
        if(y == 3){
            if(x == 2){
                y_down = -1;
            }
            else if(x == 3){
                y_down = -1;
            }
            else{
                // do nothing
            }
        }
        
        // below
        if(y == 6){
            if(x == 2){
                y_up = -1;
            }
            else if(x == 3){
                y_up = -1;
            }
            else{
                // do nothing
            }
        }

        // Lake 2:

        // left side
        if(x == 5){
            if(y == 4){
                x_right = -1;
            }
            else if(y == 5){
                x_right = -1;
            }
            else{
                // do nothing
            }
        }

        // right side
        if(x == 8){
            if(y == 4){
                x_left = -1;
            }
            else if(y == 5){
                x_left = -1;
            }
            else{
                // do nothing
            }
        }
        
        // above
        if(y == 3){
            if(x == 6){
                y_down = -1;
            }
            else if(x == 7){
                y_down = -1;
            }
            else{
                // do nothing
            }
        }
        
        // below
        if(y == 6){
            if(x == 6){
                y_up = -1;
            }
            else if(x == 7){
                y_up = -1;
            }
            else{
                // do nothing
            }
        }


        if(x_left != -1){
            list.add(new Point(x_left, y));
        }
        if(x_right != 10){
            list.add(new Point(x_right, y));
        }
        if(y_up != -1){
            list.add(new Point(x, y_up));
        }
        if(y_down != 10){
            list.add(new Point(x, y_down));
        }

        // Will still need to check the board for allies or enemies in the desired spot
            // if ally, non legal move
            // if enemy, attack sequence
        

        // remove collision with ally piece
        for (Point point : list) {
            int x_coor = (int) point.getX();
            int y_coor = (int) point.getY();

            if(board.boardSquares[x][y].occupyingPiece.color == strategoPiece.color){
                list.remove(point);
            }
        }

        return list;

    }
}
