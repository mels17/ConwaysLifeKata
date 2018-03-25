package test;

import main.Game;
import main.World;
import org.junit.Assert;
import org.junit.Test;

public class IntegratedTest {

    @Test
    public void givenWorldGameRuns() {
        World world = new World();

        Game game = new Game(world);

        Assert.assertTrue(game.run());
    }
}
