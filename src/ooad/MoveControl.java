package ooad;

import java.util.List;
import java.awt.Point;

import Pieces.MoveStrategy;
import Pieces.StrategoPiece;

public class MoveControl implements Controller{

    public void update(Square start, StrategoPiece attacker, Square end, StrategoPanel panel){

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
            return;
        }

        MoveStrategy.attack(attacker, end.occupyingPiece, panel);

        return;
        
    }
}
