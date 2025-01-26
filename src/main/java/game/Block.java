package game;

import javax.swing.ImageIcon;
import java.util.Random;

public abstract class Block extends Illustration{

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
        return "/block" + blockNumber + ".png";
    }


    public boolean isDestroyed(){
        return destroyed;
    }

    void setDestroyed(boolean boom){
        destroyed = boom;
    }

    public abstract void onHit();
}
