package game;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public final class Constants {

    // Game cycle
    public static int INTERVAL = 10;


    // Defaults
    public static final String FONT = "Minecraft";
    public static final Color FONT_COLOR_MAIN = new Color (0,0,0);
    public static final Color FONT_COLOR_ACCENTS = new Color (255, 255, 255);
    public static final Color BUTTON_COLOR_FILL = new Color (12, 64, 209);

    // Window settings
    public static final int WIDTH = 500;
    public static final int HEIGHT = 600;
    public static final int BOTTOM_EDGE = 590;

    // Game objects
    public static final int BAR_Y = 500;
    public static final int BAR_SPEED = 6;
    public static final int PEBBLE_X = WIDTH / 2;
    public static final int PEBBLE_Y = 400;
    public static final int NUM_OF_BLOCKS = 60;
}
