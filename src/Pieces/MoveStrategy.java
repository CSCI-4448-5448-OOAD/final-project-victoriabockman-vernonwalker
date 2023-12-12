package Pieces;


import java.awt.Point;
import java.util.List;

import ooad.StrategoPanel;


public interface MoveStrategy {

    List<Point> legalMoves(StrategoPiece strategoPiece, StrategoPanel board);

    static StrategoPiece attack(StrategoPiece attacker, StrategoPiece defender, StrategoPanel board){

        int attackerRank = attacker.rank;
        int defenderRank = defender.rank;

        // Spy wins if attacking Marshal first
        if(attackerRank == 1 && defenderRank == 10){
            // remove winner from old location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = null;

            // add new location to winner
            attacker.x = defender.x;
            attacker.y = defender.y;

            // delete loser and add winner to new location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = attacker;
            defender.isAlive = false;

            return attacker;
        }

        // Miner wins over bombs
        if(attackerRank == 3 && defenderRank == 11){
            // remove winner from old location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = null;

            // add new location to winner
            attacker.x = defender.x;
            attacker.y = defender.y;

            // delete loser and add winner to new location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = attacker;
            defender.isAlive = false;
            return attacker;
        }

        if(defenderRank == 0){
            // remove winner from old location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = null;

            // add new location to winner
            attacker.x = defender.x;
            attacker.y = defender.y;

            // delete loser and add winner to new location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = attacker;
            defender.isAlive = false;
            return attacker;

            // Win condition, display end of game 

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }

        if(attackerRank > defenderRank){
            // remove winner from old location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = null;

            // add new location to winner
            attacker.x = defender.x;
            attacker.y = defender.y;

            // delete loser and add winner to new location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = attacker;
            defender.isAlive = false;

            return attacker;
        }
        else if(defenderRank > attackerRank){
            // remove attacker from old location
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = null;

            // delete attacker and defender stays in orginal location
            attacker.isAlive = false;

            return defender;
        }
        else{ // TIE
            board.boardSquares[attacker.x][attacker.y].occupyingPiece = null;
            board.boardSquares[defender.x][defender.y].occupyingPiece = null;

            attacker.isAlive = false;
            defender.isAlive = false;

            return null;
        }


    }

    
    
}
