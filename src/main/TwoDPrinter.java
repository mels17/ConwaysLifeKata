package main;

public class TwoDPrinter implements Printer{

    public void print(World worldObj) throws InterruptedException {
        TwoDWorld twoDworld = (TwoDWorld) worldObj;
        boolean[][] world = twoDworld.getWorldAsArray();

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
