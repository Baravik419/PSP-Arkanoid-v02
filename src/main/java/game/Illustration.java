package game;

import lombok.Getter;
import lombok.Setter;

import java.awt.Image;
import java.awt.Rectangle;

//Enkapsuliacijos pavyzdys

@Getter
@Setter

public class Illustration {
    int x;
    int y;
    int imageWidth;
    int imageHeight;
    Image image;

    public Rectangle getRectangle() {
        return new Rectangle(x, y, imageWidth, imageHeight);
    }

    //Avoiding NullPointer except.
    public void getImageDimensions() {
        if (image != null) {
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);
        } else{
            imageWidth = 0;
            imageHeight = 0;
        }
    }
}
