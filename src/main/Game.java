package main;

public class Game {

    private World currentWorld;

    public Game(World world) {
        this.currentWorld = world;
    }

//    public boolean run() {
//        while(world is not dead) {
//            world = generateNextWorld();
//        }
//    }

    public World generateNextWorld() {
        return this.currentWorld.getNextWorld();
    }
}
