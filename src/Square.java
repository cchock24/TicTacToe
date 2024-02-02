import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private final  static int sideLength = 100;
    private final static int xBuffer = 100;
    private final static int yBuffer = 100;
    private final static int wBuffer = 23;
    private final static int uBuffer = 50;
    private final static int dBuffer = 150;

    private final static int iSize = 80;
    private final static int iBuffer = 110;

    Image x;

    Image o;
    Square[][] b;


    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
        o = new ImageIcon("Resources/Spheal.png").getImage();
        x = new ImageIcon("Resources/Crobat.png").getImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public static void drawBoard(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        for(int i = 0; i < 3; i++){
            g.drawString(String.valueOf(i), uBuffer, dBuffer + (yBuffer*i));
            g.drawString(String.valueOf(i), dBuffer + (xBuffer*i),uBuffer+wBuffer);
            for(int j = 0; j< 3; j++){
                //Draw Images for X and O
                g.drawRect(xBuffer + (j*sideLength),yBuffer + (i*sideLength),sideLength,sideLength);
            }
        }
    }

    public void drawXO(Graphics g, TicTacToeViewer t){
                //Draw Images for X and O
                if(marker.equals(TicTacToe.O_MARKER)){
                    g.drawImage(o, iBuffer + (xBuffer*col), iBuffer + (yBuffer*row), iSize, iSize, t);
                }
                if(marker.equals(TicTacToe.X_MARKER)) {
                    g.drawImage(x, iBuffer + (xBuffer * col), iBuffer + (yBuffer * row), iSize, iSize, t);
                }
    }

    public static void drawnWin(Graphics g, TicTacToe t){
        int spot = 0;
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        if(t.getWinner().equalsIgnoreCase(TicTacToe.O_MARKER)){
            g.drawString("O Wins!", 200, 450);

        }
        else if (t.getWinner().equalsIgnoreCase(TicTacToe.X_MARKER)){
            g.drawString("X Wins!", 200, 450);
        }
        else{
            g.drawString("Its a Tie!", 200, 450);
        }
    }

    public void fillWin(Graphics g, TicTacToe t){
        g.setColor(Color.green);
        if(isWinningSquare){
            g.fillRect(xBuffer + (col*sideLength), yBuffer + (row*sideLength), sideLength, sideLength);
        }
        g.setColor(Color.black);
        g.drawLine(xBuffer, yBuffer, xBuffer, yBuffer + (sideLength*3));
        g.drawLine(xBuffer + sideLength, yBuffer, xBuffer + sideLength, yBuffer + (sideLength*3));
        g.drawLine(xBuffer + (sideLength*2), yBuffer, xBuffer + (sideLength*2), yBuffer + (sideLength*3));

        g.drawLine(xBuffer, yBuffer, xBuffer + (sideLength*3), yBuffer);
        g.drawLine(xBuffer, yBuffer + sideLength, xBuffer + (sideLength*3), yBuffer + sideLength);
        g.drawLine(xBuffer, yBuffer + (sideLength*2), xBuffer + (sideLength*3), yBuffer + (sideLength*2));
    }
}
