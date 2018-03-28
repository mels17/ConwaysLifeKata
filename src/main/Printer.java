package main;

public class Printer {

    public final int SLEEP_SECONDS = 500;

    public final String LIVE_CELL = "X";
    public final String DEAD_CELL = ".";

    public void print(World worldObj) throws InterruptedException {
        boolean[][] world = worldObj.getWorld();
        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x]) {
                    stringBuilder.append(LIVE_CELL);
                } else {
                    stringBuilder.append(DEAD_CELL);
                }

                if (x == world[y].length - 1) {
                    stringBuilder.append("\n");
                }
            }
        }

        System.out.println(stringBuilder.toString());
        Thread.sleep(SLEEP_SECONDS);
    }
}
