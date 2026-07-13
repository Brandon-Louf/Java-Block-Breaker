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
    // 3x7 bricks
    private int totalBricks = 21;

    private Timer time;
    private int delay = 8;

    private int sliderX = 310;

    private int ballX = 120;
    private int ballY = 350;
    private int ballXDirect = -1;
    private int ballYDirect = -2;

    // Calls the MapGenerator
    private MapGenerator map;

    public Gameplay() {
        // Again, 3x7 bricks
        map = new MapGenerator(3, 7);
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

        // Brick Map
        map.draw((Graphics2D)g);

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
        //g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Starts the timer and recalls the graphics
        time.start();
        if(play) {
            // Adds collision between the slider and ball
            if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(sliderX, 550, 100, 8))) {
                ballYDirect = -ballYDirect;
            }
            A: for(int i = 0; i < map.map.length; i++) {
                // map.map is the Gameplay-map.MapGenerator-map
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX =  j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        // Rectangle objects for collision purposes
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            // Removes the brick by setting its position to 0
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;
                            // For intersection points
                            if (ballX + 19 <= brickRect.x || ballX + 1 >= brickRect.x + brickRect.width) {
                                ballXDirect = -ballXDirect;
                            } else {
                                ballYDirect = -ballYDirect;
                            }
                            // Breaks the loop once a brick is broken
                            break A;
                        }

                    }
                }
            }
            // Makes the ball move constantly
            ballX += ballXDirect;
            ballY += ballYDirect;
            // Inverts the direction if the side edges of the window are hit
            if (ballX < 0) {
                ballXDirect = -ballXDirect;
            }
            if (ballY < 0) {
                ballYDirect = -ballYDirect;
            }
            // And for the top (not the bottom)
            if (ballX > 670) {
                ballXDirect = -ballXDirect;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Controls for the paddle
    @Override
    public void keyPressed(KeyEvent e) {
        // Right input
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.print("Test ");
            if (sliderX >= 600) {
                System.out.println("Border");
                // Prevents the slider from going off the panel
                sliderX = 600;
            } else {
                System.out.print("Right ");
                moveRight();
            }
        }
        // Left input
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.print("Test ");
            if (sliderX < 10) {
                System.out.println("Border");
                // Prevents the slider from going off the panel
                sliderX = 10;
            } else {
                System.out.print("Left ");
                moveLeft();
            }
        }
    }

    // Movement methods called from the controls
    public void moveRight() {
        System.out.println("Input");
        play = true;
        sliderX += 20;
    }
    public void moveLeft() {
        System.out.println("Input");
        play = true;
        sliderX -= 20;
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
