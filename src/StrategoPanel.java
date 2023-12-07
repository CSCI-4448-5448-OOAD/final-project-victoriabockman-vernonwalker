import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Pieces.PieceFactory;
import Pieces.StrategoPiece;

public class StrategoPanel extends JPanel {

    public static final int BOARD_SIZE = 10;
    private StrategoBoard strategoBoard;
    private ArrayList<StrategoPiece> pieces;
    private Square[][] boardSquares;
    private int squareSize;

    public StrategoPanel() {
        this.pieces = new ArrayList<StrategoPiece>();
        this.setPreferredSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(this.getPreferredSize());
        setBorder(BorderFactory.createLineBorder(Color.black));
        initializeBoard();
        boardSquares = new Square[BOARD_SIZE][BOARD_SIZE];

        this.squareSize = this.getHeight() / BOARD_SIZE;

        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                if((i==2 || i==3 || i==6 || i==7) && (j==4 || j==5)){
                    boardSquares[i][j] = new Square(i, j, 0, this, this.squareSize);
                    this.add(boardSquares[i][j]);
                }
                else{
                    boardSquares[i][j] = new Square(i, j, 1, this, this.squareSize);
                    this.add(boardSquares[i][j]);
                }
            }
        }
    }

    public void render(Graphics g) {
        // g.drawImage(boardImage, 0, 0, null);
 
         // Draw each piece on the board
         
        for (int i = 0; i < pieces.size(); i++) {           
            if(pieces.get(i) != null){

                this.drawPiece(g, pieces.get(i));

            } 
        }    
    }

    private void initializeBoard() {
        // Load board and piece images
       // BufferedImage boardImage = loadImage("C:\\\\Users\\bockm\\Pictures\\Stratego\\board.png");

       // Image bombImage = loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/bomb.png");
       // Image spyImage = loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/spy.png");

        System.out.println("loaded");

        // Create a 10x10 board with initial piece placement
        pieces.add(PieceFactory.createPiece(6, 0, 0, "Red"));
        pieces.add(PieceFactory.createPiece(1, 0, 1, "Red"));
        pieces.add(PieceFactory.createPiece(10, 0, 2, "Red"));
        pieces.add(PieceFactory.createPiece(0, 5, 3, "Red"));

        pieces.add(PieceFactory.createPiece(5, 9, 5, "Blue"));
        pieces.add(PieceFactory.createPiece(11, 9, 3, "Blue"));
        pieces.add(PieceFactory.createPiece(2, 5, 5, "Blue"));
        pieces.add(PieceFactory.createPiece(3, 1, 1, "Blue"));

        // Need to add more pieces...

        // Create the Stratego board
       // strategoBoard = new StrategoBoard(boardImage, initialPieces);
        // this.addMouseListener(this);
        // this.addMouseMotionListener(this);

    }

    public Dimension getPreferredSize() {
        // Size of board
        return new Dimension(1000, 800);
    }

    public void paintComponent(Graphics g) {
        // super.paintComponent(g);

        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                if((j==4 || j==5) && (i==4 || i==5)){
                    boardSquares[i][j].paintComponent(g);
                }
                else{
                    boardSquares[i][j].paintComponent(g);
                }
            }
        }
    }

    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     int squareSize = getHeight() / BOARD_SIZE;

    //     // Draw the game board
    //     for (int i = 0; i < BOARD_SIZE; i++) {
    //         for (int j = 0; j < BOARD_SIZE; j++) {
    //             g.setColor(Color.green);
    //             g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
    //             g.setColor(Color.BLACK);
    //             g.drawRect(j * squareSize, i * squareSize, squareSize, squareSize);
    //         }
    //     }

    //     // DO I NEED TO FILL THE PICS HERE????

    //     g.setColor(Color.BLUE);

    //     // Fill left lake
    //     g.fillRect(2 * squareSize, 5 * squareSize, squareSize, squareSize);
    //     g.fillRect(2 * squareSize, 4 * squareSize, squareSize, squareSize);
    //     g.fillRect(3 * squareSize, 5 * squareSize, squareSize, squareSize);
    //     g.fillRect(3 * squareSize, 4 * squareSize, squareSize, squareSize);

    //     // Fill right lake
    //     g.fillRect(6 * squareSize, 5 * squareSize, squareSize, squareSize);
    //     g.fillRect(6 * squareSize, 4 * squareSize, squareSize, squareSize);
    //     g.fillRect(7 * squareSize, 5 * squareSize, squareSize, squareSize);
    //     g.fillRect(7 * squareSize, 4 * squareSize, squareSize, squareSize);


    //     this.render(g);
    // }



    BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void drawPiece(Graphics g, StrategoPiece piece){

        Image piece_image = getPieceImage(piece);

        g.drawImage(piece_image.getScaledInstance((this.getHeight() / StrategoPanel.BOARD_SIZE) - 20,
                (this.getHeight() / StrategoPanel.BOARD_SIZE) - 20, Image.SCALE_SMOOTH), 
                (piece.x * (this.getHeight() / StrategoPanel.BOARD_SIZE) + 10),
                (piece.y * (this.getHeight() / StrategoPanel.BOARD_SIZE) + 5), null);

    }


    private Image getPieceImage(StrategoPiece piece){
        String col = "";
        String end = "";

        if(piece.color == "Red"){
            col = "RED_";
        }
        else{
            col = "BLUE_";
        }

        switch (piece.rank) {
            case 1:
                end = "SPY.png";
                break;

            case 2:
                end = "SCOUT.png";
                break;

            case 3:
                end = "MINER.png";
                break;

            case 4:
                end = "SERGEANT.png";
                break;

            case 5:
                end = "LIEUTENANT.png";
                break;

            case 6:
                end = "CAPTAIN.png";
                break;

            case 7:
                end = "MAJOR.png";
                break;

            case 8:
                end = "COLONEL.png";
                break;

            case 9:
                end = "GENERAL.png";
                break;

            case 10:
                end = "MARSHAL.png";
                break;
            
            case 0:
                end = "FLAG.png";
                break;

            case -1:
                end = "BOMB.png";
                break;
        
            default:
                break;
        }

        String img_name = col + end;

        Image image = this.loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/"
        + img_name);

        return image;
    }

}