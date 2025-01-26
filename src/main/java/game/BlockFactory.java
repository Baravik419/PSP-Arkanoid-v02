package game;

public class BlockFactory {
    public static Block createBlock(int type, int x, int y) {
        return switch (type) {
            case 0 -> new BlockNormal(x, y);
            case 1 -> new BlockIndestructible(x, y);
            default -> throw new IllegalArgumentException("Invalid block type");
        };
    }
}