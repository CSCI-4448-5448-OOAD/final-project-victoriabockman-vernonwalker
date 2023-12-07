package Move;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


import Pieces.StrategoPiece;

public class NoMove implements MoveStrategy{
    
    @Override
    public List<Point> legalMoves(StrategoPiece strategoPiece, StrategoPanel board){

        List<Point> emptyList = new ArrayList<>();
        return emptyList;

    }

}
