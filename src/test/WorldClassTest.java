package test;

import main.TwoDWorld;
import org.junit.Assert;
import org.junit.Test;

public class WorldClassTest {

    @Test
    public void givenDeadWorldReturnDeadWorld() {
        TwoDWorld expected = new TwoDWorld(new boolean[3][3]);
        TwoDWorld actual = expected.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenAnySizeDeadWorldReturnSameSizeDeadWorld() {
        TwoDWorld expected = new TwoDWorld(new boolean[4][4]);
        TwoDWorld actual = expected.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenAnyRectangleDeadWorldReturnSameRectangleDeadWorld() {
        TwoDWorld expected = new TwoDWorld(new boolean[15][4]);
        TwoDWorld actual = expected.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenUnderpopulatedLivingCellWithNoLivingNeighboursReturnDeadCell() {
        TwoDWorld input = new TwoDWorld(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, false}
        });

        TwoDWorld expected = new TwoDWorld(new boolean[3][3]);
        TwoDWorld actual = input.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenUnderpopulatedLivingCellWithOneLivingNeighbourReturnDeadCell() {
        TwoDWorld input = new TwoDWorld(new boolean[][]{
                new boolean[]{true, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, false}
        });

        TwoDWorld expected = new TwoDWorld(new boolean[3][3]);
        TwoDWorld actual = input.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenNormallyPopulatedLivingCellWithThreeLivingNeighboursReturnLivingCell() {
        TwoDWorld input = new TwoDWorld(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, true, true},
                new boolean[]{false, false, false}
        });

        TwoDWorld expected = new TwoDWorld(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, true, true},
                new boolean[]{true, true, true}
        });
        TwoDWorld actual = input.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenNormallyPopulatedLivingCellWithTwoLivingNeighboursReturnLivingCell() {
        TwoDWorld input = new TwoDWorld(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{true, true, true},
                new boolean[]{false, false, false}
        });

        TwoDWorld expected = new TwoDWorld(new boolean[][]{
                new boolean[]{true, true, true},
                new boolean[]{true, true, true},
                new boolean[]{true, true, true}
        });
        TwoDWorld actual = input.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenOverpopulatedLivingCellWithThreeLivingNeighboursReturnDeadCell() {
        TwoDWorld input = new TwoDWorld(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, true, true},
                new boolean[]{false, true, false}
        });

        TwoDWorld expected = new TwoDWorld(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{false, false, false},
                new boolean[]{false, true, false}
        });

        TwoDWorld actual = input.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }

    @Test
    public void givenNormallyPopulatedDeadCellWithThreeLivingNeighboursReturnLivingCell() {
        TwoDWorld input = new TwoDWorld(new boolean[][]{
                new boolean[]{false, true, false},
                new boolean[]{true, false, false},
                new boolean[]{false, true, false}
        });

        TwoDWorld expected = new TwoDWorld(new boolean[][]{
                new boolean[]{false, false, false},
                new boolean[]{true, true, true},
                new boolean[]{false, false, false}
        });
        TwoDWorld actual = input.getNextWorld();
        Assert.assertArrayEquals(expected.getWorldAsArray(), actual.getWorldAsArray());
    }
}
