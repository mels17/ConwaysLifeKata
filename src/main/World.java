package main;

public class World {

    private boolean[][] world;

    public World() {
        this.world = new boolean[3][3];
    }

    public World(boolean[][] world) {
        this.world = world;
    }

    public boolean[][] getWorld() {
        return world;
    }

    private boolean getNorth(int x, int y) {
        int newY = y - 1;
        int newX = x;

        if (newY < 0) {
            return false;
        }

        return world[newY][newX];
    }

    private boolean getNorthEast(int x, int y) {
        int newY = y - 1;
        int newX = x + 1;

        if (newY < 0) {
            return false;
        }

        if (newX > world[y].length - 1) {
            newX = 0;
        }

        return world[newY][newX];
    }

    private boolean getEast(int x, int y) {
        int newY = y;
        int newX = x + 1;

        if (newX > world[y].length - 1) {
            newX = 0;
        }

        return world[newY][newX];
    }

    private boolean getSouthEast(int x, int y) {
        int newY = y + 1;
        int newX = x + 1;

        if (newY > world.length - 1) {
            return false;
        }

        if (newX > world[y].length - 1) {
            newX = 0;
        }

        return world[newY][newX];
    }

    private boolean getSouth(int x, int y) {
        int newY = y + 1;
        int newX = x;

        if (newY > world.length - 1) {
            return false;
        }

        return world[newY][newX];
    }

    private boolean getSouthWest(int x, int y) {
        int newY = y + 1;
        int newX = x - 1;

        if (newY > world.length - 1) {
            return false;
        }

        if (newX < 0) {
            newX = world[y].length - 1;
        }

        return world[newY][newX];
    }

    private boolean getWest(int x, int y) {
        int newY = y;
        int newX = x - 1;

        if (newX < 0) {
            newX = world[y].length - 1;
        }

        return world[newY][newX];
    }

    private boolean getNorthWest(int x, int y) {
        int newY = y - 1;
        int newX = x - 1;

        if (newY < 0) {
            return false;
        }

        if (newX < 0) {
            newX = world[y].length - 1;
        }

        return world[newY][newX];
    }

    private int getNumberOfLivingNeighbours(int x, int y) {
        int livingCounter = 0;

        if (getNorth(x, y)) {
            livingCounter++;
        }
        ;

        if (getNorthEast(x, y)) {
            livingCounter++;
        }
        ;

        if (getEast(x, y)) {
            livingCounter++;
        }
        ;

        if (getSouthEast(x, y)) {
            livingCounter++;
        }
        ;

        if (getSouth(x, y)) {
            livingCounter++;
        }
        ;

        if (getSouthWest(x, y)) {
            livingCounter++;
        }
        ;

        if (getWest(x, y)) {
            livingCounter++;
        }
        ;

        if (getNorthWest(x, y)) {
            livingCounter++;
        }
        ;

        return livingCounter;
    }

    public World getNextWorld() {
        World nextWorld = new World(new boolean[3][3]);

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world.length; x++) {
                if (world[y][x] && (getNumberOfLivingNeighbours(x, y) == 2 || getNumberOfLivingNeighbours(x, y) == 3)) {
                    nextWorld.getWorld()[y][x] = true;
                }
            }
        }

        return nextWorld;
    }

    public boolean equals2(World worldToCompare) {
        if (worldToCompare.getWorld().length != world.length) {
            return false;
        }

        if (world.length > 0 && worldToCompare.getWorld()[0].length != world[0].length) {
            return false;
        }

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world.length; x++) {
                if (worldToCompare.getWorld()[y][x] != world[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }
}
