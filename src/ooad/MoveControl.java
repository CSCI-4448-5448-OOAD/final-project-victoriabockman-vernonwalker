package ooad;

import java.util.List;
import java.awt.Point;

// COMMAND PATTERN
// MVC PATTERN

import Pieces.MoveStrategy;
import Pieces.StrategoPiece;

// interacts with both the model and view in order to move piece around upon user input

public class MoveControl implements Controller{

    // update is called when user tries to move something from the view
    public void update(Square start, StrategoPiece attacker, Square end, StrategoPanel panel){

        // only allow the player to move their own pieces. 
        if(panel.curr_player == 1 && attacker.color == "Blue"){
            return;
        }
        if(panel.curr_player == 2 && attacker.color == "Red"){
            return;
        }

        // interacts with the move strategy in order to find which moves are legal
        List<Point> legalMoves = attacker.moveStrategy.legalMoves(attacker, panel);

        boolean isLegal = false;

        System.out.println(end.xNum + " " + end.yNum);

        System.out.println(legalMoves.size());

        for(int i = 0; i < legalMoves.size(); i++){ 
            int x = (int) legalMoves.get(i).getX();
            int y = (int) legalMoves.get(i).getY();

            if(x == end.xNum && y == end.yNum){
                isLegal = true;
            }
        }

        // only allow the move if it is legal
        if(!isLegal){
            return;
        }

        // move the piece
        if(end.occupyingPiece == null){
            attacker.x = end.xNum;
            attacker.y = end.yNum;
            start.occupyingPiece = null;
            end.occupyingPiece = attacker;
            panel.curr_player = 3 - panel.curr_player;
            return;
        }

        // if there is another piece, try and attack it. 
        MoveStrategy.attack(attacker, end.occupyingPiece, panel);

        panel.curr_player = 3 - panel.curr_player;

        return;
        
    }


    public void update(){
        // do nothing
    }

    public void update(StrategoPanel p){
        // do nothing
    }
}
