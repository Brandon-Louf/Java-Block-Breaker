import java.awt.*;

public class MapGenerator {
    // Setup for an array grid of bricks
    public int map[][];
    public int blockWidth;
    public int blockHeight;
    public MapGenerator(int row, int col) {
        map = new int[row][col];
        // Positions of the bricks
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        blockWidth = 540/col;
        blockHeight = 150/row;
    }
    public void draw(Graphics2D g) {
        // Positions of the graphics (matching the bricks)
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // Draw a graphic if at a brick position
                if (map[i][j] > 0) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(j * blockWidth + 88, i * blockHeight + 50, blockWidth, blockHeight);

                    // Adds a boarder of 3 to each brick
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * blockWidth + 88, i * blockHeight + 50, blockWidth, blockHeight);
                }
            }
        }
    }
    public void setBlockValue(int value, int row, int col) {
        map[row][col] = value;
    }
}
