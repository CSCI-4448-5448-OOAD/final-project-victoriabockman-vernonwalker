package ooad;

import Pieces.StrategoPiece;

public class ExitControl implements Controller {

    @Override
    public void update(Square s, StrategoPiece a, Square e, StrategoPanel p) {
        // do nothing
    }

    public void update(){
        System.out.println("Exitting Program...");
        System.exit(0);
    }
    
    public void update(StrategoPanel p){
        // do nothing
    }
    
}
