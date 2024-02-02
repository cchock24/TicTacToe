import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int WINDOWN_WIDTH = 600;
    private final int WINDOOW_HEIGHT = 500;

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
        g.setColor(Color.black);
        b = t.getBoard();
        Square.drawBoard(g);
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[i].length; j++){
                b[i][j].drawXO(g, this);
            }
        }
        if(t.getGameOver()){
            Square.drawnWin(g, t);
            for(int i = 0; i < b.length; i++){
                for(int j = 0; j < b[i].length; j++){
                    b[i][j].fillWin(g, t);
                    b[i][j].drawXO(g, this);
                }
            }
        }


    }
}


