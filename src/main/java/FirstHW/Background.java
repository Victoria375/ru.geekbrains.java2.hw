package FirstHW;

import java.awt.*;
import java.util.Random;

public class Background {
    private static Random rnd = new Random();
    private Color color;

    Background() {
    }

    void changeBackground(GameCanvas canvas) {
        color = new Color(rnd.nextInt());
        canvas.setBackground(color);
    }
}


