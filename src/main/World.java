package main;

public class World {

    public final boolean ALIVE = true;

    private boolean[][] world;

    public World(boolean[][] world) {
        this.world = world;
    }

    public boolean[][] getWorld() {
        return world;
    }

    public World getNextWorld() {
        Neighbour neighbour = new Neighbour(this.world);

        World nextWorld = new World(new boolean[world.length][world.length == 0 ? 0 : world[0].length]);

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {

                int noOfLivingNeighbours = neighbour.getNumberOfLivingNeighbours(x, y);
                if (world[y][x] && (noOfLivingNeighbours == 2 || noOfLivingNeighbours == 3)) {
                    nextWorld.getWorld()[y][x] = ALIVE;
                }

                if (!world[y][x] && (noOfLivingNeighbours == 3)) {
                    nextWorld.getWorld()[y][x] = ALIVE;
                }

            }
        }
        return nextWorld;
    }
}
