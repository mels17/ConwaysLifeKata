package main;

public class TwoDNeighbour implements Neigbour {
    public boolean[][] world;

    public final int WORLD_START_X = 0;
    public final int WORLD_START_Y = 0;
    public int worldEndX;
    public int worldEndY;

    public TwoDNeighbour(boolean[][] world) {

        this.world = world;

        worldEndY = this.world.length - 1;
        worldEndX = this.world[worldEndY].length - 1;
    }

    private boolean isNorthOutOfBounds(int y) {
        return y < WORLD_START_Y;
    }

    private boolean isEastOutOfBounds(int x, int y) {
        return x > worldEndX;
    }

    private boolean isSouthOutOfBounds(int y) {
        return y > worldEndY;
    }

    private boolean isWestOutOfBounds(int x) {
        return x < WORLD_START_X;
    }

    private boolean getNorth(int x, int y) {
        int newY = y - 1;
        int newX = x;

        if (isNorthOutOfBounds(newY)) {
            return DEAD;
        }

        return world[newY][newX];
    }

    private boolean getNorthEast(int x, int y) {
        int newY = y - 1;
        int newX = x + 1;

        if (isNorthOutOfBounds(newY)) {
            return DEAD;
        }

        if (isEastOutOfBounds(newX, newY)) {
            newX = WORLD_START_X;
        }

        return world[newY][newX];
    }

    private boolean getEast(int x, int y) {
        int newY = y;
        int newX = x + 1;

        if (isEastOutOfBounds(newX, newY)) {
            newX = WORLD_START_X;
        }

        return world[newY][newX];
    }

    private boolean getSouthEast(int x, int y) {
        int newY = y + 1;
        int newX = x + 1;

        if (isSouthOutOfBounds(newY)) {
            return DEAD;
        }

        if (isEastOutOfBounds(newX, newY)) {
            newX = WORLD_START_X;
        }

        return world[newY][newX];
    }

    private boolean getSouth(int x, int y) {
        int newY = y + 1;
        int newX = x;

        if (isSouthOutOfBounds(newY)) {
            return DEAD;
        }

        return world[newY][newX];
    }

    private boolean getSouthWest(int x, int y) {
        int newY = y + 1;
        int newX = x - 1;

        if (isSouthOutOfBounds(newY)) {
            return DEAD;
        }

        if (isWestOutOfBounds(newX)) {
            newX = worldEndX;
        }

        return world[newY][newX];
    }

    private boolean getWest(int x, int y) {
        int newY = y;
        int newX = x - 1;

        if (isWestOutOfBounds(newX)) {
            newX = worldEndX;
        }

        return world[newY][newX];
    }

    private boolean getNorthWest(int x, int y) {
        int newY = y - 1;
        int newX = x - 1;

        if (isNorthOutOfBounds(newY)) {
            return DEAD;
        }

        if (isWestOutOfBounds(newX)) {
            newX = worldEndX;
        }

        return world[newY][newX];
    }

    public int getNumberOfLivingNeighbours(int x, int y) {
        int livingCounter = 0;

        if (getNorth(x, y)) {
            livingCounter++;
        };

        if (getNorthEast(x, y)) {
            livingCounter++;
        };

        if (getEast(x, y)) {
            livingCounter++;
        };

        if (getSouthEast(x, y)) {
            livingCounter++;
        };

        if (getSouth(x, y)) {
            livingCounter++;
        };

        if (getSouthWest(x, y)) {
            livingCounter++;
        };

        if (getWest(x, y)) {
            livingCounter++;
        };

        if (getNorthWest(x, y)) {
            livingCounter++;
        };

        return livingCounter;
    }
}
