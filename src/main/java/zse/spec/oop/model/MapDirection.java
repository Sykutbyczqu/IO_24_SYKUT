package zse.spec.oop.model;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    @Override
    public String toString() {
        switch (this) {
            case EAST: return "Wschód";
            case WEST: return "Zachód";
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            default: throw new IllegalArgumentException();
        }
    }

    public MapDirection next() {
        switch (this) {
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            case NORTH: return EAST;
            default: throw new IllegalArgumentException();
        }
    }

    public MapDirection previous() {
        switch (this) {
            case EAST: return NORTH;
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            default: throw new IllegalArgumentException();
        }
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH: return new Vector2d(0, 1);
            case SOUTH: return new Vector2d(0, -1);
            case WEST: return new Vector2d(-1, 0);
            case EAST: return new Vector2d(1, 0);
            default: throw new IllegalArgumentException();
        }
    }
}