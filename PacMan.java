import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashSet;
import java.util.Random;

public class PacMan extends JPanel {

    class Block{
        int X;
        int Y;
        int width;
        int height;
        Image image;

        int startX;
        int startY;

        Block (int X , int Y , int width , int height , Image image){
            this.X = X;
            this.Y = Y;
            this.width = width;
            this.height = height;
            this.image = image;
        }
    }
    
    private int numRows = 21;
    private int numCols = 19;
    private int tileSize = 32;
    private int boardWidth = tileSize * numCols;
    private int boardHeight = tileSize * numRows;

    //Image Variables (Pacman)
    private Image packmanUp;
    private Image packmanLeft;
    private Image packmanDown;
    private Image packmanRight;

    //Image Variables (Ghosts)
    private Image ghostRed;
    private Image ghostBlue;
    private Image ghostOrange;
    private Image ghostPink;

    //Image variable (Boundary)
    private Image boundaryImage;

    //Hashset Vraibales
    Block pacman;
    HashSet<Block> ghosts;
    HashSet<Block> boundaries;

     HashSet<Block> foods;

    //X is our boundary , P is pacman , [r,b,p,o] represent our ghosts and O represent the powerups
    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };
    PacMan(){

        setPreferredSize(new Dimension(boardWidth , boardHeight));
        setBackground(Color.BLACK);
        
        //Pack-Man Images
        packmanUp = new ImageIcon(getClass().getResource("./Images/pacmanUp.png")).getImage();
        packmanLeft = new ImageIcon(getClass().getResource("./Images/pacmanLeft.png")).getImage();
        packmanDown = new ImageIcon(getClass().getResource("./Images/pacmanDown.png")).getImage();
        packmanRight = new ImageIcon(getClass().getResource("./Images/pacmanRight.png")).getImage();

        //Ghost Images
        ghostRed = new ImageIcon(getClass().getResource("./Images/redGhost.png")).getImage();
        ghostBlue = new ImageIcon(getClass().getResource("./Images/blueGhost.png")).getImage();
        ghostOrange = new ImageIcon(getClass().getResource("./Images/orangeGhost.png")).getImage();
        ghostPink = new ImageIcon(getClass().getResource("./Images/pinkGhost.png")).getImage();

        //Boundary Image
        boundaryImage = new ImageIcon(getClass().getResource("./Images/wall.png")).getImage();

        loadMap();
    }

    public void loadMap(){
        boundaries = new HashSet<Block>();
        ghosts = new HashSet<Block>();
        foods = new HashSet<Block>();

        for (int i =0 ; i < numRows ; i++){
            for (int j = 0 ; j < numCols ; j++){
                String row = tileMap[i];
                char tileMapChar = row.charAt(j);

                int X = j * tileSize;
                int Y = i * tileSize;

                if (tileMapChar == 'X'){
                    Block boundary = new Block (X,Y,tileSize,tileSize,boundaryImage);
                    boundaries.add(boundary);
                }

                else if (tileMapChar == 'b'){
                    Block ghost = new Block(X,Y,tileSize,tileSize,ghostBlue);
                    ghosts.add(ghost);
                }

                else if (tileMapChar == 'o'){
                    Block ghost = new Block(X,Y,tileSize,tileSize,ghostOrange);
                    ghosts.add(ghost);
                }

                else if (tileMapChar == 'r'){
                    Block ghost = new Block(X,Y,tileSize,tileSize,ghostRed);
                    ghosts.add(ghost);
                }

                else if (tileMapChar == 'p'){
                    Block ghost = new Block(X,Y,tileSize,tileSize,ghostPink);
                    ghosts.add(ghost);
                }

                else if (tileMapChar == 'P'){
                    pacman = new Block(X, Y, tileSize,tileSize, packmanRight);
                }

                else if (tileMapChar == ' '){
                    Block food = new Block (X+14,Y+14,4,4,null);
                    foods.add(food);
                }


            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.drawImage(pacman.image,pacman.X,pacman.Y,pacman.width,pacman.height,null);

        for (Block ghost : ghosts){
            g.drawImage(ghost.image,ghost.X,ghost.Y,ghost.height,ghost.width,null);
        }

        for (Block boundary : boundaries){
            g.drawImage(boundary.image , boundary.X , boundary.Y,boundary.width , boundary.height,null);
        }

        g.setColor(Color.WHITE);

        for (Block food : foods){
            g.fillRect(food.X,food.Y,food.width,food.height);
        }
    }

}





