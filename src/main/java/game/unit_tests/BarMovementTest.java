package game.unit_tests;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;

import game.Bar;
import game.Constants;

public class BarMovementTest {

    @Test
    public void testBarMovement() {
        //arrange
        Bar bar = new Bar();
        bar.setX(200);

        //acct no1
        bar.keyPressed(new KeyEvent((Component) new Object(), 0, 0, 0, KeyEvent.VK_LEFT, ' '));
        bar.move();

        //assert no1
        assertEquals(200 - Constants.BAR_SPEED, bar.getX(), "Turejo pajudeti i kaire.");

        //act no2
        bar.keyPressed(new KeyEvent((Component) new Object(), 0, 0, 0, KeyEvent.VK_RIGHT, ' '));
        bar.move();

        //assert no2
        assertEquals(200, bar.getX(), "Turejo pajudeti i pradine pozicija.");
    }
}