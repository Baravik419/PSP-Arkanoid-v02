package game;

// Polimorfizmo pavyzdys

public class BlockNormal extends Block {

    public BlockNormal(int x, int y) {
        super(x, y);
    }

    @Override
    public void onHit() {
        setDestroyed(true); // Normal blocks are destroyed on hit
    }
}
