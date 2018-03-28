package main;

public interface World {
    boolean ALIVE = true;
    boolean DEAD = false;

    World getWorld();

    World getNextWorld();
}
