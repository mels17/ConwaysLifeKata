package test;

import main.World;
import org.junit.Assert;
import org.junit.Test;

public class WorldClassTest {

    @Test
    public void givenDeadWorldReturnDeadWorld() {
        World expected = new World(new boolean[3][3]);
        World actual = expected.getNextWorld();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenAnySizeDeadWorldReturnSameSizeDeadWorld() {
        World expected = new World(new boolean[4][4]);

        World actual = expected.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenAnyRectangleDeadWorldReturnSameRectangleDeadWorld() {
        World expected = new World(new boolean[15][4]);


        World actual = expected.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenUnderpopulatedLivingCellWithNoLivingNeighboursReturnDeadCell() {
        World input = new World(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, false}
        });

        World expected = new World(new boolean[3][3]);


        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenUnderpopulatedLivingCellWithOneLivingNeighbourReturnDeadCell() {
        World input = new World(new boolean[][]{
                new boolean[]{true, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, false}
        });

        World expected = new World(new boolean[3][3]);


        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenNormallyPopulatedLivingCellWithThreeLivingNeighboursReturnLivingCell() {
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


        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenNormallyPopulatedLivingCellWithTwoLivingNeighboursReturnLivingCell() {
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


        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenOverpopulatedLivingCellWithThreeLivingNeighboursReturnDeadCell() {
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

        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenNormallyPopulatedDeadCellWithThreeLivingNeighboursReturnLivingCell() {
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

        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenNormallyPopulatedDeadCellWithThreeLivingNeighboursReturnLivingCell2() {
        World input = new World(new boolean[][]{
                new boolean[]{true, true, true},
                new boolean[]{true, true, true},
                new boolean[]{true, true, true}
        });

        World expected = new World(new boolean[3][3]);

        World actual = input.getNextWorld();

        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void givenNormallyPopulatedDeadCellWithThreeLivingNeighboursReturnLivingCell() {
//        World input = new World(new boolean[][]{
//                new boolean[]{true,false, true, false},
//                new boolean[]{true, false, false},
//                new boolean[]{false, true, false}
//        });
//
//        World expected = new World(new boolean[][]{
//                new boolean[]{false, false, false},
//                new boolean[]{true, true, true},
//                new boolean[]{false, false, false}
//        });
//
//        Game game = new Game(input);
//
//        World actual = game.generateNextWorld();
//
//        Assert.assertEquals(expected, actual);
//    }
}
