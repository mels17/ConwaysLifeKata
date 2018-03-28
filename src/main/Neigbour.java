package main;

public interface Neigbour {
    boolean DEAD = false;
    boolean ALIVE = true;

    int getNumberOfLivingNeighbours(int x, int y);
}
