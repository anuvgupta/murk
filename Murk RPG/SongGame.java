
import java.lang.Exception;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SongGame extends JPanel
{
    static int keyX = -1;
    static int newX = -1;
    static int score = 0;
    static int lives = 5;
    static String currRow = "||||";
    static int state = 0;
    static int total = 0;

    static int songLength = 10;
    static double speed = 1;

    public SongGame() {
        KeyListener l1 = new KL();
        addKeyListener(l1);
        setFocusable(true);
    }

    public static void prepGame(int sL, double sp) {
        keyX = -1;
        newX = -1;
        score = 0;
        lives = 5;
        String currRow = "||||";
        state = 0;
        total = 0;

        state = 0;
        songLength = sL;
        speed = sp;
    }

    @SuppressWarnings("serial")
    public static void play() {

        final String CLEAR = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        String newTab = "";
        String currTab;
        String[] tabs = new String[songLength];
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        for (int i = 0; i < songLength; i++) {
            tabs[i] = ("||||");
        }

        GFrame frame = new GFrame("Satyrs", 500, 500);
        SongGame framePanel = new SongGame();
        frame.add(framePanel);
        frame.setVisible(true);
        framePanel.requestFocusInWindow();

        while(state == 0) {

            //System.out.println(CLEAR);
            //System.out.println("Score: " + score);
            //System.out.println("Lives: " + lives);
            //System.out.println("\n  A S D F  ");

            currTab = "";
            for (int i = 0; i < tabs.length; i++) {
                /*
                String aT = "";
                String bT = "";
                for (int z = 0; z < 4; z++) {
                aT = tabs[i];
                bT = aT.substring(i, i + 1);
                }
                 */
                //currTab += "  " + bT + "  " + "\n";
                currTab += "  " + tabs[i] + "  " + "\n";
            }
            //System.out.println(currTab.replace("|", "|      ").replace("0", "0      "));

            total++;
            currRow = tabs[songLength - 1];
            String newLT = "<center>Score: " + score + "\n" + "Lives: " + lives + "\n" + "</center>\n  A     S     D     F  " + "\n" + currTab.replace("|", "|      ").replace("0", "0      ") + "\n";
            frame.changeLabel("<html>" + newLT.replace("\n", "<br/>").replace(" ", "&nbsp;") + "</html>");

            try {
                Thread.sleep((int)(speed * 1000.0));
            }
            catch (Exception e) {
                //System.out.println("Cannot sleep: " + e.getMessage());
                break;
            }

            for (int i = songLength - 1; i > 0; i--) tabs[i] = tabs[i - 1];

            newTab = "";
            newX = rand.nextInt(4);
            for (int i = 0; i < 4; i++) {
                if (i == newX) newTab += "0";
                else newTab += "|";
            }
            tabs[0] = newTab;

        }

        //System.out.println(CLEAR);

    }

    public class KL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) { 
            //System.out.println("keyTyped = " + KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed = " + KeyEvent.getKeyText(e.getKeyCode()));
            int k = e.getKeyCode();
            if (k == KeyEvent.VK_A) keyX = 0;
            if (k == KeyEvent.VK_S) keyX = 1;
            if (k == KeyEvent.VK_D) keyX = 2;
            if (k == KeyEvent.VK_F) keyX = 3;

            int currX = currRow.indexOf("0");
            //System.out.println(currRow);
            //System.out.println(currX);

            if (keyX == currX) score++;
            else lives--;

            if (lives <= 0) state = 1;
            else if (score >= 25) state = 2;
            else if ((total >= 25) && (score < 25)) state = 3;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("keyReleased = " + KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}

class GFrame extends JFrame {

    private JLabel label;

    public GFrame(String title, int x, int y) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(x, y));
        label = new JLabel("GAME", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(x, y));
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void changeLabel(String t) {
        label.setText(t);
    }

}
