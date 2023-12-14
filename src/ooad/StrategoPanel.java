package ooad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;

import javax.imageio.ImageIO;

import Pieces.StrategoPiece;

public class StrategoPanel extends JPanel implements MouseListener, MouseMotionListener{

    public static final int BOARD_SIZE = 10;
    
    public ArrayList<StrategoPiece> pieces;
    public Square[][] boardSquares;
    private int squareSize;
    private StrategoPiece currPiece;
    private int currY;
    private int currX;
    private String color;
    private Square start;
    private Controller controller;
    private PresetBoards presets;

    public StrategoPanel(String c) {
        this.presets = new PresetBoards();
        this.controller = null;
        this.color = c;
        this.pieces = new ArrayList<StrategoPiece>();
        this.setPreferredSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(this.getPreferredSize());
        // setBorder(BorderFactory.createLineBorder(Color.black));
        boardSquares = new Square[BOARD_SIZE][BOARD_SIZE];
        setLayout(new GridLayout(10,10,0,0));
        this.squareSize = this.getHeight() / BOARD_SIZE;

        for(int j = 0; j < BOARD_SIZE; j++){
            for(int i = 0; i < BOARD_SIZE; i++){
                if((i==2 || i==3 || i==6 || i==7) && (j==4 || j==5)){
                    boardSquares[i][j] = new Square(i, j, 0, this, this.squareSize);
                    this.add(boardSquares[i][j]);
                    boardSquares[i][j].setBounds(i * this.getHeight() / StrategoPanel.BOARD_SIZE,
                                                 j * this.getHeight() / StrategoPanel.BOARD_SIZE, 
                                                 this.squareSize, this.squareSize);
                }
                else{
                    boardSquares[i][j] = new Square(i, j, 1, this, this.squareSize);
                    this.add(boardSquares[i][j]);
                    boardSquares[i][j].setBounds(i * this.getHeight() / StrategoPanel.BOARD_SIZE,
                                                 j * this.getHeight() / StrategoPanel.BOARD_SIZE, 
                                                 this.squareSize, this.squareSize);
                    this.add(boardSquares[i][j]);
                }
            }
        }

        presets.Deboer1("Red", this);
        presets.Deboer2("Blue", this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("Mouse pressed function activated");
        currX = e.getX();
        currY = e.getY();

        Square s = (Square) this.getComponentAt(new Point(currX, currY));

        System.out.println(s.xNum + " " + s.yNum);

        if(s.getPiece() == null){
            this.currPiece = null;
            return;
        }

        this.currPiece = s.getPiece();
        this.start = s;

        System.out.println(this.currPiece);

        if(this.currPiece.color != this.color){
            return;
        }

        this.repaint();


    }

    @Override
    public void mouseReleased(MouseEvent e){

        System.out.println("Mouse released function activated");

        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));

        System.out.println(sq.xNum + " " + sq.yNum);
        System.out.println(this.currPiece);

        this.controller = new MoveControl();

        if(this.currPiece != null){

            this.controller.update(this.start, this.currPiece, sq, this);

        }
        else{
            System.out.println("This piece is null!");
            return;
        }

        this.controller = null;

        this.currPiece = null;
        this.start = null;
        this.currX = e.getX();
        this.currY = e.getY();

        this.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e){
        
    }

    @Override
    public void mouseMoved(MouseEvent e){
        
    }

    @Override
    public void mouseClicked(MouseEvent e){
        
    }

    @Override
    public void mouseEntered(MouseEvent e){
        
    }

    @Override
    public void mouseExited(MouseEvent e){
        
    }

    // public void render(Graphics g) {
    //     // g.drawImage(boardImage, 0, 0, null);
 
    //      // Draw each piece on the board
         
    //     for (int i = 0; i < pieces.size(); i++) {           
    //         if(pieces.get(i) != null){

    //             this.drawPiece(g, pieces.get(i));

    //         } 
    //     }    
    // }

    private void initializeBoard() {
        // Load board and piece images
       // BufferedImage boardImage = loadImage("C:\\\\Users\\bockm\\Pictures\\Stratego\\board.png");

       // Image bombImage = loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/bomb.png");
       // Image spyImage = loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/spy.png");

        System.out.println("loaded");

        // Create a 10x10 board with initial piece placement
        createNewPiece(6, 0, 0, "Red");
        createNewPiece(1, 0, 1, "Red");
        createNewPiece(10, 0, 2, "Red");
        createNewPiece(0, 5, 3, "Red");

        createNewPiece(5, 9, 5, "Blue");
        createNewPiece(11, 9, 3, "Blue");
        createNewPiece(2, 5, 5, "Blue");
        createNewPiece(3, 1, 1, "Blue");

        // Need to add more pieces...

        // Create the Stratego board
       // strategoBoard = new StrategoBoard(boardImage, initialPieces);
        // this.addMouseListener(this);
        // this.addMouseMotionListener(this);

    }

    private void createNewPiece(int rank, int x, int y, String c){
        pieces.add(PieceFactory.createPiece(rank, x, y, c, this.boardSquares[x][y]));
    }

    public Dimension getPreferredSize() {
        // Size of board
        return new Dimension(1000, 1000);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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
                end = "SPY-min.png";
                break;

            case 2:
                end = "SCOUT-min.png";
                break;

            case 3:
                end = "MINER-min.png";
                break;

            case 4:
                end = "SERGEANT-min.png";
                break;

            case 5:
                end = "LIEUTENANT-min.png";
                break;

            case 6:
                end = "CAPTAIN-min.png";
                break;

            case 7:
                end = "MAJOR-min.png";
                break;

            case 8:
                end = "COLONEL-min.png";
                break;

            case 9:
                end = "GENERAL-min.png";
                break;

            case 10:
                end = "MARSHAL-min.png";
                break;
            
            case 0:
                end = "FLAG-min.png";
                break;

            case 11:
                end = "BOMB-min.png";
                break;
        
            default:
                break;
        }

        String img_name = col + end;

        Image image = this.loadImage("/Users/vernonwalker/Desktop/All Other Classes/Object Oriented Programming/final-project-victoriabockman/src/Stratego/"
        + img_name);

        return image;
    }

    public void reset(){
        this.presets = null;
        this.presets = new PresetBoards();
        this.controller = null;
        this.pieces = null;
        this.pieces = new ArrayList<StrategoPiece>();
        // setBorder(BorderFactory.createLineBorder(Color.black));
        for(int j = 0; j < BOARD_SIZE; j++){
            for(int i = 0; i < BOARD_SIZE; i++){
                this.remove(boardSquares[j][i]);
            }
        }
        this.boardSquares = null;
        boardSquares = new Square[BOARD_SIZE][BOARD_SIZE];

        for(int j = 0; j < BOARD_SIZE; j++){
            for(int i = 0; i < BOARD_SIZE; i++){
                if((i==2 || i==3 || i==6 || i==7) && (j==4 || j==5)){
                    boardSquares[i][j] = new Square(i, j, 0, this, this.squareSize);
                    this.add(boardSquares[i][j]);
                    boardSquares[i][j].setBounds(i * this.getHeight() / StrategoPanel.BOARD_SIZE,
                                                 j * this.getHeight() / StrategoPanel.BOARD_SIZE, 
                                                 this.squareSize, this.squareSize);
                }
                else{
                    boardSquares[i][j] = new Square(i, j, 1, this, this.squareSize);
                    this.add(boardSquares[i][j]);
                    boardSquares[i][j].setBounds(i * this.getHeight() / StrategoPanel.BOARD_SIZE,
                                                 j * this.getHeight() / StrategoPanel.BOARD_SIZE, 
                                                 this.squareSize, this.squareSize);
                    this.add(boardSquares[i][j]);
                }
            }
        }

        presets.Deboer1("Red", this);
        presets.Deboer2("Blue", this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
}