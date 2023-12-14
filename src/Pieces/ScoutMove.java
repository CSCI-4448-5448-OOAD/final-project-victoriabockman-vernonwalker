package Pieces;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ooad.StrategoPanel;

public class ScoutMove implements MoveStrategy{

    // The Scout can make subsequent attacks if there is an enemy nearby
    
    @Override
    public List<Point> legalMoves(StrategoPiece strategoPiece, StrategoPanel board){

        // This implementation allows for the jumping over of pieces at the moment
        // It currently only works to ensure no lake jumping or going out of bounds for legal moves

        List<Point> list = new CopyOnWriteArrayList<>();
        
        int x = strategoPiece.x;
        int y = strategoPiece.y;

        int x_left = x - 1;
        int x_right = x + 1;

        int y_up = y - 1;
        int y_down = y + 1;

        // Add all legal moves moving left
        while(x_left != -1){
            // if we check x_left, y for an enemy or ally here we can change the current rules
            if(board.boardSquares[x_left][y].getColor() == 0){
                break;
            }
            if(board.boardSquares[x_left][y].occupyingPiece != null){
                list.add(new Point(x_left, y));
                break;
            }
            else{
                list.add(new Point(x_left, y));
            }

            x_left = x_left - 1;
        }

        // Add all legal moves moving right
        while(x_right != 10){
            // if we check x_right, y for an enemy or ally here we can change the current rules
            if(board.boardSquares[x_right][y].getColor() == 0){
                break;
            }
            if(board.boardSquares[x_right][y].occupyingPiece != null){
                list.add(new Point(x_right, y));
                break;
            }
            else{
                list.add(new Point(x_right, y));
            }

            x_right = x_right + 1;
        }

        // Add all legal moves moving up
        while(y_up != -1){
            // if we check x, y_up for an enemy or ally here we can change the current rules
            if(board.boardSquares[x][y_up].getColor() == 0){
                break;
            }
            if(board.boardSquares[x][y_up].occupyingPiece != null){
                list.add(new Point(x, y_up));
                break;
            }
            else{
                list.add(new Point(x, y_up));
            }

            y_up = y_up - 1;
        }

        // Add all legal moves moving down
        while(y_down != 10){
            // if we check x, y_down for an enemy or ally here we can change the current rules
            if(board.boardSquares[x][y_down].getColor() == 0){
                break;
            }
            if(board.boardSquares[x][y_down].occupyingPiece != null){
                list.add(new Point(x, y_down));
                break;
            }
            else{
                list.add(new Point(x, y_down));
            }

            y_down = y_down + 1;
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