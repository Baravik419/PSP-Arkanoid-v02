package game;

// Polimorfizmo pavyzdys

public class BlockIndestructible extends Block {

    public BlockIndestructible(int x, int y) {
        super(x, y);
    }

    @Override
    public void onHit() {
    }
}
