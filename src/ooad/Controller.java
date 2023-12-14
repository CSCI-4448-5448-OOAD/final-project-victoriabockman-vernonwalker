package ooad;

// COMMAND PATTERN
// MVC PATTERN

import Pieces.StrategoPiece;

public interface Controller {
    
    public void update(Square s, StrategoPiece a, Square e, StrategoPanel p);
    public void update();
    public void update(StrategoPanel p);

}