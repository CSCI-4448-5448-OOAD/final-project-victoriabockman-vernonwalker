package ooad;
import Pieces.StrategoPiece;


public class PresetBoards {



    public void Deboer1(String color, StrategoPanel strategoBoard){

        int[] list1 = {3,3,11,0,11,3,2,11,3,2};
        int[] list2 = {4,6,5,11,5,8,7,4,11,4};
        int[] list3 = {2,8,7,7,2,9,1,11,4,5};
        int[] list4 = {6,2,10,3,6,2,5,2,2,6};
    
        if(color.equals("Red")){
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list1[i], i, 0, color, strategoBoard.boardSquares[i][0]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list2[i], i, 1, color, strategoBoard.boardSquares[i][1]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list3[i], i, 2, color, strategoBoard.boardSquares[i][2]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list4[i], i, 3, color, strategoBoard.boardSquares[i][3]));
            }
        }

        int[] list5 = reverse(list4);
        int[] list6 = reverse(list3);
        int[] list7 = reverse(list2);
        int[] list8 = reverse(list1);

        if(color.equals("Blue")){
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list5[i], i, 6, color, strategoBoard.boardSquares[i][6]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list6[i], i, 7, color, strategoBoard.boardSquares[i][7]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list7[i], i, 8, color, strategoBoard.boardSquares[i][8]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list8[i], i, 9, color, strategoBoard.boardSquares[i][9]));
            }
        }
    }

    public void Deboer2(String color, StrategoPanel strategoBoard){

        int[] list1 = {3,11,11,0,11,4,3,3,3,7};
        int[] list2 = {2,5,4,11,5,6,1,7,2,7};
        int[] list3 = {5,11,11,4,2,9,8,8,2,4};
        int[] list4 = {6,2,2,2,6,2,3,5,6,10};
    
        if(color.equals("Red")){
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list1[i], i, 0, color, strategoBoard.boardSquares[i][0]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list2[i], i, 1, color, strategoBoard.boardSquares[i][1]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list3[i], i, 2, color, strategoBoard.boardSquares[i][2]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list4[i], i, 3, color, strategoBoard.boardSquares[i][3]));
            }
        }

        int[] list5 = reverse(list4);
        int[] list6 = reverse(list3);
        int[] list7 = reverse(list2);
        int[] list8 = reverse(list1);

        if(color.equals("Blue")){
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list5[i], i, 6, color, strategoBoard.boardSquares[i][6]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list6[i], i, 7, color, strategoBoard.boardSquares[i][7]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list7[i], i, 8, color, strategoBoard.boardSquares[i][8]));
            }
            for(int i = 0; i < 10; i++){
                strategoBoard.pieces.add(PieceFactory.createPiece(list8[i], i, 9, color, strategoBoard.boardSquares[i][9]));
            }
        }
    }

    public int[] reverse(int[] list){
        for (int i = 0; i < list.length / 2; i++) {
            int temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }

        return list;
    }
}