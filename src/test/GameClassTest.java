package test;

import main.Game;
import main.TwoDPrinter;
import main.TwoDWorld;
import main.World;
import org.junit.Assert;
import org.junit.Test;

public class GameClassTest {

    @Test
    public void givenNumberOfGenerationReturnsArrayOfWorld() throws InterruptedException {
        TwoDWorld world = new TwoDWorld(new boolean[3][3]);
        TwoDPrinter printer = new TwoDPrinter();
        Game game = new Game(world, printer);
        World[] actual = game.getNextWorlds(5);
        Assert.assertEquals(actual.length, 5);
    }
}
