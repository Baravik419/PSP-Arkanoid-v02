package game.unit_tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Pebble;
import game.Block;
import game.Bar;
import game.CollisionHandler;
import game.Constants;

public class PebbleCollisionTest {

    @Test
    public void testPebbleEdgeCollision() {
        //arrange no1
        Pebble pebble = new Pebble();
        pebble.setX(0); // Place at the left edge
        pebble.setxPebble(-1); // Moving left

        CollisionHandler collisionHandler = new CollisionHandler(pebble, new Bar(), new Block[0]);

        //act no1
        collisionHandler.checkCollision();

        //assert no1
        assertEquals(1, pebble.getXPebble(), "Pebble should flip direction.");

        //arrange no2
        pebble.setX(Constants.WIDTH - pebble.getImageWidth());
        pebble.setxPebble(1); // Moving right

        //act no2
        collisionHandler.checkCollision();

        //assert no2
        assertEquals(-1, pebble.getXPebble(), "Pebble should flip direction.");
    }
}