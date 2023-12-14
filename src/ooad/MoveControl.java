package ooad;

import java.util.List;
import java.awt.Point;

// COMMAND PATTERN
// MVC PATTERN

import Pieces.MoveStrategy;
import Pieces.StrategoPiece;

public class MoveControl implements Controller{

    // Red player is 1
    // Blue player is 2

    // Red starts first

    public void update(Square start, StrategoPiece attacker, Square end, StrategoPanel panel){

        if(panel.curr_player == 1 && attacker.color == "Blue"){
            return;
        }
        if(panel.curr_player == 2 && attacker.color == "Red"){
            return;
        }

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

        if(!isLegal){
            return;
        }

        if(end.occupyingPiece == null){
            attacker.x = end.xNum;
            attacker.y = end.yNum;
            start.occupyingPiece = null;
            end.occupyingPiece = attacker;
            panel.curr_player = 3 - panel.curr_player;
            return;
        }

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
