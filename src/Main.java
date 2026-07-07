import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // The JFrame is the window in which the game is played and its attributes
        JFrame object = new JFrame();
        Gameplay gamePlay = new Gameplay();
        object.setBounds(10, 10, 700, 600);
        object.setTitle("Breaker Ball");
        object.setResizable(false);
        object.setVisible(true);
        object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        object.add(gamePlay);

        // Adds the Gameplay class/properties to the window
        Gameplay gameStart = new Gameplay();
        object.add(gameStart);
    }
}
