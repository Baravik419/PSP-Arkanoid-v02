package game;

import javax.swing.ImageIcon;
import java.util.Random;

//Abstract pavyzdys

public abstract class Block extends Illustration{


    //Enkapsuliacijos pavyzdys
    private boolean destroyed;

    public Block(int x, int y){
        this.x = x;
        this.y = y;
        destroyed = false;
        loadImage();
        getImageDimensions();
    }

    private void loadImage() {
        try {
            var icon = new ImageIcon(getClass().getResource(getRandomImagePath()));
            image = icon.getImage();
        } catch (NullPointerException e) {
            System.err.println("Error loading image");
        }
    }

    private String getRandomImagePath(){
        Random random = new Random();
        int blockNumber = random.nextInt(4) + 1;
        return "/Illustrations/block" + blockNumber + ".png";
    }


    public boolean isDestroyed(){
        return destroyed;
    }

    void setDestroyed(boolean boom){
        destroyed = boom;
    }


    // Behavioral design pavyzdys

    public abstract void onHit();
}
