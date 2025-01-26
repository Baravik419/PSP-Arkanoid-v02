package game;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Bar extends Illustration{

    private int velocityX;

    public Bar(){
        initBar();
        x = (Constants.WIDTH - imageWidth) / 2;
        y = Constants.BAR_Y;
    }

    private void initBar(){
        loadImage();
        getImageDimensions();
    }

    //Bar illustration

    private void loadImage(){
        try {
            var icon = new ImageIcon(getClass().getResource("/bar.png"));
            image = icon.getImage();
        } catch (NullPointerException e) {
            System.err.println("Error loading image");
        }

    }

    //Bar movement mechanics

    public void move() {
        x += velocityX;

        if (isAtLeftBoundary()) {
            x = 0;
        } else if (isAtRightBoundary()) {
            x = Constants.WIDTH - imageWidth;
        }
    }

    private boolean isAtLeftBoundary() {
        return x <= 0;
    }

    private boolean isAtRightBoundary() {
        return x >= Constants.WIDTH - imageWidth;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            velocityX = Constants.BAR_SPEED*-1;
        } else if(key == KeyEvent.VK_RIGHT){
            velocityX = Constants.BAR_SPEED;
        }
    }


    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
            velocityX = 0;
        }
    }
}
