package main;

public interface Printer {
    int SLEEP_SECONDS = 500;

    String LIVE_CELL = "X";
    String DEAD_CELL = ".";

    void print(World world) throws InterruptedException;
}
