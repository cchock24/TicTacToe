import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int WINDOWN_WIDTH = 600;
    private final int WINDOOW_HEIGHT = 500;
    private final int sideLength = 100;
    private final int xBuffer = 100;
    private final int yBuffer = 100;
    private final int wBuffer = 23;
    private final int uBuffer = 50;
    private final int dBuffer = 150;

    private final int iSize = 80;
    private final int iBuffer = 110;



    Image x;

    Image o;

    Square[][] b;

    TicTacToe t;

    public TicTacToeViewer(TicTacToe t){
        this. t = t;
        o = new ImageIcon("Resources/Spheal.png").getImage();
        x = new ImageIcon("Resources/Crobat.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOWN_WIDTH, WINDOOW_HEIGHT);
        b = t.getBoard();
        this.setVisible(true);
    }

    public void paint(Graphics g){
        //Draw Board
        b = t.getBoard();
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        for(int i = 0; i < 3; i++){
            g.drawString(String.valueOf(i), uBuffer, dBuffer + (yBuffer*i));
            g.drawString(String.valueOf(i), dBuffer + (xBuffer*i),uBuffer+wBuffer);
            for(int j = 0; j< 3; j++){
                //Draw Images for X and O
                g.drawRect(xBuffer + (j*sideLength),yBuffer + (i*sideLength),sideLength,sideLength);
                if(b[i][j].getMarker().equals(TicTacToe.O_MARKER)){
                    g.drawImage(o, iBuffer + (xBuffer*j), iBuffer + (yBuffer*i), iSize, iSize, this);
                }
                if(b[i][j].getMarker().equals(TicTacToe.X_MARKER)){
                    g.drawImage(x, iBuffer + (xBuffer*j), iBuffer + (yBuffer*i), iSize, iSize, this);
                }
            }
        }
        if(t.getGameOver()){
            this.drawWin(g);
        }


    }

    public void drawWin(Graphics g){
        int spot = 0;
        g.setColor(Color.green);
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        if(t.getWinner().equalsIgnoreCase(TicTacToe.O_MARKER)){
            g.drawString("O Wins!", 200, 450);
            if(t.getwinDirection() == TicTacToe.COL_WIN){
                spot = t.getwinIndex();
                for(int i = 0; i < 3; i++){
                    g.fillRect(xBuffer, yBuffer + (spot*sideLength), sideLength, sideLength);
                }
            }
            else if(t.getwinDirection() == TicTacToe.ROW_WIN){
                spot = t.getwinIndex();
                for(int i = 0; i < 3; i++){
                    g.fillRect(xBuffer + (spot*sideLength), yBuffer, sideLength, sideLength);
                }
            }

        }
        else if (t.getWinner().equalsIgnoreCase(TicTacToe.X_MARKER)){
            g.drawString("X Wins!", 200, 450);
        }
        else{
            g.drawString("Its a Tie!", 200, 450);
        }

    }
}


