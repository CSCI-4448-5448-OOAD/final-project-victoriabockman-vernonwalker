package Pieces;


import java.awt.Point;
import java.util.List;

import ooad.StrategoPanel;


public interface MoveStrategy {

    List<Point> legalMoves(StrategoPiece strategoPiece, StrategoPanel board);

    static StrategoPiece attack(StrategoPiece attacker, StrategoPiece defender){

        int attackerRank = attacker.rank;
        int defenderRank = defender.rank;

        // Spy wins if attacking first
        if(attackerRank == 1 && defenderRank == 10){
            return attacker;
        }

        // Miner wins over bombs
        if(attackerRank == 3 && defenderRank == 11){
            return attacker;
        }

        if(defenderRank == 0){
            return attacker;

            // Win condition, display end of game 
        }

        if(attackerRank > defenderRank){
            return attacker;
        }
        else if(defenderRank > attackerRank){
            return defender;
        }
        else{
            return null;
        }


    }

    
    
}
