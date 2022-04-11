package FirstHW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Ball[] sprites = new Ball[10];

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] != null) {
                sprites[i].update(canvas, deltaTime);
            }
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] != null) {
                sprites[i].render(canvas, g);
            }
        }
    }
    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) {
        update(c, deltaTime);
        render(c, g);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void increaseSize() {
        Ball[] sprites2 = new Ball[sprites.length + 1];
        for (int i = 0; i < sprites.length; i++) {
            sprites2[i] = sprites[i];
        }
        sprites = sprites2;
        sprites[sprites.length - 1] = new Ball();
    }

    public void decreaseSize() {
        Ball[] sprites2 = new Ball[sprites.length - 1];
        for (int i = 0; i < sprites.length - 1; i++) {
            sprites2[i] = sprites[i];
        }
        sprites = sprites2;
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        setVisible(true);
        Background bg = new Background();
        bg.changeBackground(canvas);
        //клик левой кнопкой мыши прибавляет один шарик, правой - удаляет
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getModifiersEx() == e.BUTTON1_DOWN_MASK) {
                    increaseSize();
                } else if (e.getModifiersEx() == e.BUTTON3_DOWN_MASK) {
                    decreaseSize();
                }
            }
        });
    }

    public static void main(String[] args) {
        new MainCircles();
    }

}
