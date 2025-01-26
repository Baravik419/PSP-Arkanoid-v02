package game;

import javax.swing.ImageIcon;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Pebble extends Illustration{

    private int xPebble;
    private int yPebble;

    public Pebble(){
        initPebble();
    }

    private void initPebble(){
        xPebble = 1;
        yPebble = -1;

        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage(){
        Random random = new Random();
        int pebbleNumber = random.nextInt(3) + 1; // Random num 1/3
        try {
            var icon = new ImageIcon(getClass().getResource("/pebble" + pebbleNumber + ".png"));
            image = icon.getImage();
        } catch (NullPointerException e) {
            System.err.println("Error loading image");
        }
    }

    void move(){
        x += xPebble;
        y += yPebble;

        if (x == 0){
            setxPebble(1);
        }

        if (x == Constants.WIDTH - imageWidth){
            setxPebble(-1);
        }

        if (y == 0){
            setyPebble(1);
        }
    }

    private void resetState(){
        x = Constants.PEBBLE_X;
        y = Constants.PEBBLE_Y;
    }

    public void setxPebble(int x){
        xPebble = x;
    }

    public void setyPebble(int y){
        yPebble = y;
    }

}
