package main;

public class TwoDWorld implements World{
    private boolean[][] world;

    public TwoDWorld(boolean[][] world) {
        this.world = world;
    }

    public TwoDWorld getWorld() {
        return this;
    }

    public boolean[][] getWorldAsArray() {
        return this.world;
    }

    public TwoDWorld getNextWorld() {
        TwoDNeighbour neighbour = new TwoDNeighbour(this.world);

        TwoDWorld nextWorld = new TwoDWorld(new boolean[world.length][world.length == 0 ? 0 : world[0].length]);

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {

                int noOfLivingNeighbours = neighbour.getNumberOfLivingNeighbours(x, y);
                if (world[y][x] && (noOfLivingNeighbours == 2 || noOfLivingNeighbours == 3)) {
                    nextWorld.getWorldAsArray()[y][x] = ALIVE;
                }

                if (!world[y][x] && (noOfLivingNeighbours == 3)) {
                    nextWorld.getWorldAsArray()[y][x] = ALIVE;
                }

            }
        }
        return nextWorld;
    }
}
