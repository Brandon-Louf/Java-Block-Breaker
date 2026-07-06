import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* Extends from JPanel to inherit its properties and mesh with the window
* Implements KeyListener and ActionListener for controls */
public class Gameplay extends JPanel implements KeyListener, ActionListener {
    // Game only starts with our input with a score of 0
    private boolean play = false;
    private int score = 0;
    // 7x3 bricks
    private int totalBricks = 21;

    private Timer time;
    private int delay = 8;

    private int sliderX = 310;

    private int ballX = 120;
    private int ballY = 350;
    private int ballXDirect = -1;
    private int ballYDirect = -2;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
