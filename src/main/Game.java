package main;

public class Game {

    private World currentWorld;
    private Printer printer;

    public Game(World world, Printer printer) {
        this.currentWorld = world;
        this.printer = printer;
    }

    public World[] run(int numGenerations) {
        World[] worlds = new World[numGenerations];
        for(int i = 0; i < numGenerations; i++) {
            World nextWorld = currentWorld.getNextWorld();
            worlds[i] = nextWorld;
            currentWorld = nextWorld;
        }
        return worlds;
    }

    public void display(World[] worlds) throws InterruptedException {
        for (World world: worlds) {
            printer.print(world);
            Thread.sleep(500);
        }
    }
}
