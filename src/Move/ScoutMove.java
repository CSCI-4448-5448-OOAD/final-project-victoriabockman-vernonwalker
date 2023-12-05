package Move;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Pieces.StrategoPiece;

public class ScoutMove implements MoveStrategy{
    
    @Override
    public List<Point> legalMoves(StrategoPiece strategoPiece){

        // This implementation allows for the jumping over of pieces at the moment
        // It currently only works to ensure no lake jumping or going out of bounds for legal moves

        List<Point> list = new ArrayList<>();
        
        int x = strategoPiece.x;
        int y = strategoPiece.y;

        int x_left = x - 1;
        int x_right = x + 1;

        int y_up = y - 1;
        int y_down = y + 1;

        // Add all legal moves moving left
        while(x_left != -1){
            // if we check x_left, y for an enemy or ally here we can change the current rules
            if(x_left == 7 && y == 4){
                break;
            }
            else if(x_left == 7 && y == 5){
                break;
            }
            else if(x_left == 3 && y == 4){
                break;
            }
            else if(x_left == 3 && y == 5){
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
            if(x_right == 2 && y == 4){
                break;
            }
            else if(x_right == 2 && y == 5){
                break;
            }
            else if(x_right == 6 && y == 4){
                break;
            }
            else if(x_right == 6 && y == 5){
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
            if(y_up == 5 && x == 2){
                break;
            }
            else if(y_up == 5 && x == 3){
                break;
            }
            else if(y_up == 5 && x == 6){
                break;
            }
            else if(y_up == 5 && x == 7){
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
            if(y_down == 4 && x == 2){
                break;
            }
            else if(y_down == 4 && x == 3){
                break;
            }
            else if(y_down == 4 && x == 6){
                break;
            }
            else if(y_down == 4 && x == 7){
                break;
            }
            else{
                list.add(new Point(x, y_down));
            }

            y_down = y_down + 1;
        }

        return list;
    }
}