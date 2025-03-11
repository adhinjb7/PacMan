import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacMan extends JPanel {
    
    private int numRows = 21;
    private int numCols = 19;
    private int tileSize = 32;
    private int boardWidth = tileSize * numCols;
    private int boardHeight = tileSize * numRows;

    private Image packmanUp;
    private Image packmanLeft;
    private Image packmanDown;
    private Image packmanRight;

    private Image ghostRed;
    private Image ghostBlue;
    private Image ghostOrange;
    private Image ghostPink;

    private Image boundaryImage;

    public PacMan(){

        setPreferredSize(new Dimension(boardWidth , boardHeight));
        setBackground(Color.BLACK);

        packmanUp = new ImageIcon(getClass().getResource("./Images/packmanUp.png")).getImage();
        packmanLeft = new ImageIcon(getClass().getResource("./Images/packmanLeft.png")).getImage();
        packmanDown = new ImageIcon(getClass().getResource("./Images/packmanDown.png")).getImage();
        packmanRight = new ImageIcon(getClass().getResource("./Images/packmanRight.png")).getImage();

        ghostRed = new ImageIcon(getClass().getResource("./Images/redGhost.png")).getImage();
        ghostBlue = new ImageIcon(getClass().getResource("./Images/blueGhost.png")).getImage();
        ghostOrange = new ImageIcon(getClass().getResource("./Images/orangeGhost.png")).getImage();
        ghostPink = new ImageIcon(getClass().getResource("./Images/pinkGhost.png")).getImage();

        boundaryImage = new ImageIcon(getClass().getResource("./Images/wall.png")).getImage();
    }


}
