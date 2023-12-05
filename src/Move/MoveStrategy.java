package Move;

import java.awt.Point;
import java.util.List;

import Pieces.StrategoPiece;

public interface MoveStrategy {

    List<Point> legalMoves(StrategoPiece strategoPiece);
    
}
