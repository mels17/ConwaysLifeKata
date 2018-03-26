package main;

public class Printer {

    public void print(World worldObj) {
        boolean[][] world = worldObj.getWorld();
        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x]) {
                    stringBuilder.append("x");
                } else {
                    stringBuilder.append("o");
                }

                if (x == world[y].length - 1) {
                    stringBuilder.append("\n");
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
