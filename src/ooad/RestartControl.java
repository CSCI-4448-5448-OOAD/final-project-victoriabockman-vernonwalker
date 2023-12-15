package ooad;

import Pieces.StrategoPiece;

public class RestartControl implements Controller {

    @Override
    public void update(Square s, StrategoPiece a, Square e, StrategoPanel p) {
     // do nothing
    }

    // intermediary method for interaction between the viewer and the model
    // part of the Controller interface.
    
    @Override
    public void update(StrategoPanel p) {

        p.reset();
    }

    public void update(){
        // do nothing
    }
    
}
