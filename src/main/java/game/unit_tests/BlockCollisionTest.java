package game.unit_tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Pebble;
import game.Block;
import game.Bar;
import game.BlockNormal;
import game.CollisionHandler;

public class BlockCollisionTest {

    @Test
    public void testBlockCollision() {
        //arrange
        Pebble pebble = new Pebble();
        pebble.setX(50);
        pebble.setY(50);
        pebble.getImageDimensions();

        Block block = new BlockNormal(50, 50);
        block.getImageDimensions();

        Block[] blocks = {block};
        Bar bar = new Bar();
        CollisionHandler collisionHandler = new CollisionHandler(pebble, bar, blocks);

        //act
        collisionHandler.checkCollision();

        //assert
        assertTrue(block.isDestroyed(), "The block should be destroyed after collision.");
    }
}