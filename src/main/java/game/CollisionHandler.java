package game;

import java.awt.*;

public class CollisionHandler {

    private final Pebble pebble;
    private final Bar bar;
    private final Block[] blocks;

    public CollisionHandler(Pebble pebble, Bar bar, Block[] blocks) {
        this.pebble = pebble;
        this.bar = bar;
        this.blocks = blocks;
    }

    public boolean checkCollision() {
        if(checkEdgeCollision()){
            return true;
        }
        checkBarCollision();
        checkBlockCollision();
        return false;
    }

    private boolean checkEdgeCollision() {
        // Bottom collision
        if (pebble.getRectangle().getMaxY() > Constants.BOTTOM_EDGE) {
            return true;
        }

        // L/R Collision
        if (pebble.getRectangle().getMinX() <= 0) {
            pebble.setxPebble(1); // Reverse horizontal direction
        }

        if (pebble.getRectangle().getMaxX() >= Constants.WIDTH) {
            pebble.setxPebble(-1);
        }

        // Top collision
        if (pebble.getRectangle().getMinY() <= 0) {
            pebble.setyPebble(1);
        }

        return false;
    }

    private void checkBarCollision() {
        int barLPos = bar.getX();
        int barWidth = bar.getImageWidth();
        int pebbleLPos = pebble.getX();

        int hitPosition = pebbleLPos - barLPos;
        int section = barWidth / 5;

        if(!pebble.getRectangle().intersects(bar.getRectangle())) return;

        if (hitPosition < section) {
            pebble.setxPebble(-2);
            pebble.setyPebble(-1);
        } else if (hitPosition < 2 * section) {
            pebble.setxPebble(-1);
            pebble.setyPebble(-1);
        } else if (hitPosition < 3 * section) {
            pebble.setxPebble(0);
            pebble.setyPebble(-1);
        } else if (hitPosition < 4 * section) {
            pebble.setxPebble(1);
            pebble.setyPebble(-1);
        } else {
            pebble.setxPebble(2);
            pebble.setyPebble(-1);
        }

        // Adjusting
        pebble.setY(bar.getY() - pebble.getImageHeight());
    }


    private void checkBlockCollision() {
        Rectangle pebbleRect = pebble.getRectangle();

        for (int i = 0; i < blocks.length; i++) {
            Block block = blocks[i];

            if (!block.isDestroyed() && pebbleRect.intersects(block.getRectangle())) {
                block.onHit();

                if(!block.isDestroyed()){
                    resolveBlockCollision(pebbleRect, block.getRectangle());
                }
            }
        }
    }

    private void resolveBlockCollision(Rectangle pebbleRect, Rectangle blockRect) {
        // Horizontal collision
        if (pebbleRect.getMaxX() >= blockRect.getMinX() && pebbleRect.getMinX() <= blockRect.getMinX()) {
            pebble.setxPebble(-1); // Move left
        } else if (pebbleRect.getMinX() <= blockRect.getMaxX() && pebbleRect.getMaxX() >= blockRect.getMaxX()) {
            pebble.setxPebble(1); // Move right
        }

        // Vertical collision
        if (pebbleRect.getMaxY() >= blockRect.getMinY() && pebbleRect.getMinY() <= blockRect.getMinY()) {
            pebble.setyPebble(-1); // Move up
        } else if (pebbleRect.getMinY() <= blockRect.getMaxY() && pebbleRect.getMaxY() >= blockRect.getMaxY()) {
            pebble.setyPebble(1); // Move down
        }
    }
}
