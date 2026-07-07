import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

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

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
    }

    // Defines the graphics
    public void paint(Graphics g) {
        // Background
        g.setColor(Color.BLUE);
        g.fillRect(1, 1, 692, 592);

        // Boarder
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // Slider
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(sliderX, 550, 100, 8);

        // Ball
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(ballX, ballY, 20, 20);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Starts the timer and recalls the graphics
        time.start();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Controls for the paddle
    @Override
    public void keyPressed(KeyEvent e) {
        // Left input
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (sliderX >= 600) {
                // Prevents the slider from going off the panel
                sliderX = 600;
            } else {
                moveLeft();
            }
        }
        // Right input
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (sliderX < 10) {
                // Prevents the slider from going off the panel
                sliderX = 10;
            } else {
                moveRight();
            }
        }
    }

    // Movement methods called from the controls
    public void moveLeft() {
        play = true;
        sliderX -= 20;
    }
    public void moveRight() {
        play = true;
        sliderX += 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
