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

    @Test
    public void givenCustomDeadWorldReturnNextWorld() {
        World expected = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{false, false, false},
                new boolean[]{false, false, false}
        });

        Game game = new Game(expected);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }

    @Test
    public void givenCenterLivingWorldReturnNextWorld() {
        World input = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, false}
        });

        World expected = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{false, false, false},
                new boolean[]{false, false, false}
        });

        Game game = new Game(input);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }

    @Test
    public void givenCenterLivingWithOneLivingNeighboursWorldReturnNextWorld() {
        World input = new World(new boolean[][]{
                new boolean[]{true, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, false}
        });

        World expected = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{false, false, false},
                new boolean[]{false, false, false}
        });

        Game game = new Game(input);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }

    @Test
    public void givenCenterLivingWithThreeLivingNeighboursWorldReturnNextWorld() {
        World input = new World(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, true, true},
                new boolean[]{false, false, false}
        });

        World expected = new World(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, true, true},
                new boolean[]{true, true, true}
        });

        Game game = new Game(input);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }

    @Test
    public void givenCenterLivingWithTwoLivingNeighboursWorldReturnNextWorld() {
        World input = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{true, true, true},
                new boolean[]{false, false, false}
        });

        World expected = new World(new boolean[][]{
                new boolean[]{true, true, true},
                new boolean[]{true, true, true},
                new boolean[]{true, true, true}
        });

        Game game = new Game(input);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }

    @Test
    public void givenCenterLivingWithFourLivingNeighboursWorldReturnNextWorld() {
        World input = new World(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, true, true},
                new boolean[]{false, true, false}
        });

        World expected = new World(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{false, false, false},
                new boolean[]{false, true, false}
        });

        Game game = new Game(input);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }

    @Test
    public void givenCenterDeadWithThreeLivingNeighboursWorldReturnNextWorld() {
        World input = new World(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, false, false},
                new boolean[]{false, true, false}
        });

        World expected = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{true, true, true},
                new boolean[]{false, false, false}
        });

        Game game = new Game(input);

        World actual = game.generateNextWorld();

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.equals2(expected));
    }
}
