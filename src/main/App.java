package main;

public class App {

    public static void main(String[] args) {
        TwoDWorld world = new TwoDWorld(new boolean[][]{
                new boolean[]{false, false, false, true, false, true, true, false, true},
                new boolean[]{true, true, false, true, false, true, true, false, true},
                new boolean[]{false, false, true, false, true, true, true, false, true},
                new boolean[]{true, false, false, true, false, true, true, false, true},
                new boolean[]{true, true, true, true, false, true, true, false, true},
                new boolean[]{false, false, true, false, false, true, true, false, true},
                new boolean[]{true, false, false, true, false, true, true, false, true},
                new boolean[]{true, true, true, true, false, true, true, false, true},
                new boolean[]{false, false, true, false, false, true, true, false, true},

        });
        Printer printer = new TwoDPrinter();
        Game game = new Game(world, printer);
        game.run(10);
    }
}
