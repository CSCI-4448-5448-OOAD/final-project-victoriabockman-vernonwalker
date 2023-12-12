package ooad;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

import Pieces.MoveStrategy;
import Pieces.NoMove;
import Pieces.NormalMove;
import Pieces.ScoutMove;
import Pieces.StrategoPiece;

public class Controller {
    
    public void Move(Square start, StrategoPiece attacker, Square end, StrategoPanel panel){

        List<Point> legalMoves = attacker.moveStrategy.legalMoves(attacker, panel);

        boolean isLegal = false;

        Point endPoint = new Point(end.xNum, end.yNum);

        for(int i = 0; i < legalMoves.size(); i++){
            if(legalMoves.get(i) == endPoint){
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
            return;
        }

        
        
    }

}
