package main;

public class World {

    private boolean[][] world;

    public World() {
    }

    public World(boolean[][] world) {
        this.world = world;
    }

    public boolean[][] getWorld() {
        return world;
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
