import javax.swing.JFrame;

public class Main{

    public static void main (String[] args){

        int numRows = 21;
        int numCols = 19;
        int tileSize = 32;
        int boardWidth = tileSize * numCols;
        int boardHeight = tileSize * numRows;

        JFrame initialFrame = new JFrame ("PAC-MAN");
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setResizable(false);
        initialFrame.setLocationRelativeTo(null);
        initialFrame.setSize(boardWidth , boardHeight);

        PacMan pacman = new PacMan();
        initialFrame.add(pacman);
        initialFrame.pack();
        initialFrame.setVisible(true);
    }
}
