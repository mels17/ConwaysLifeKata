package test;

import main.Game;
import main.World;
import org.junit.Assert;
import org.junit.Test;

public class IntegratedTest {

//    @Test
//    public void givenWorldGameRuns() {
//        World world = new World();
//
//        Game game = new Game(world);
//
//        Assert.assertTrue(game.run());
//    }

//    @Test
//    public void afterGameRunsCurrentGameWorldShouldBeDead() {
//        World world = new World();
//
//        Game game = new Game(world);
//
//        World currentWorld = game.getCurrentWorld();
//
//        Assert.assertTrue(currentWorld.isDead());
//    }

    @Test
    public void givenWorldReturnNextWorld() {
        World world = new World();

        Game game = new Game(world);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
    }
}
