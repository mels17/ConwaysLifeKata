package main;

public class Game {

    private World currentWorld;

    public Game(World world) {
        this.currentWorld = world;
    }

    public boolean run() {
        return true;
    }

    public World generateNextWorld() {
        return this.currentWorld.getNextWorld();
    }
}
