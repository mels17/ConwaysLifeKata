package main;

public class Game {

    public Game(World world) {
    }

    public boolean run() {
        return true;
    }

    public World generateNextWorld() {
        return new World();
    }
}
