package Pieces;


import java.awt.Point;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ooad.StrategoPanel;

public class NormalMove implements MoveStrategy{

   // private static final Object lock = new Object();
    
    @Override
    public List<Point> legalMoves(StrategoPiece strategoPiece, StrategoPanel board){

        List<Point> list = new CopyOnWriteArrayList<>();

        int x = strategoPiece.x;
        int y = strategoPiece.y;

        int x_left = x - 1;
        int x_right = x + 1;

        int y_up = y - 1;
        int y_down = y + 1;


        // ADD the four possible moves to the list, if they exist within bounds


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

        // remove collision with ally piece
        
        for (Point point : list) {
            int x_coor = (int) point.getX();
            int y_coor = (int) point.getY();

            if(board.boardSquares[x_coor][y_coor].occupyingPiece != null){
                if(board.boardSquares[x_coor][y_coor].occupyingPiece.color == strategoPiece.color){
                    list.remove(point);
                }
            }
            if(board.boardSquares[x_coor][y_coor].getColor() == 0){
                list.remove(point);
            }
        }
        

        return list;

    }
}
