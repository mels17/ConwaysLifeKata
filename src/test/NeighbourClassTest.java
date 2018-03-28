package test;

import main.Neighbour;
import org.junit.Assert;
import org.junit.Test;

public class NeighbourClassTest {


    @Test
    public void getTheNumberOfLivingCellsSuccessfully() {

        boolean[][] world = new boolean[][] {
                new boolean[] { false, true, false},
                new boolean[] { true, true, false},
                new boolean[] { false, true, true},
        };

        Neighbour neighbour = new Neighbour(world);

        Assert.assertEquals(3, neighbour.getNumberOfLivingNeighbours(0,0));
    }

    @Test
    public void initializesWorldLengthBreadthSuccessfully() {

        boolean[][] world = new boolean[][] {
                new boolean[] { false, false, false},
                new boolean[] { false, false, false},
                new boolean[] { false, false, false},
        };

        Neighbour neighbour = new Neighbour(world);

        Assert.assertEquals(0, neighbour.getNumberOfLivingNeighbours(0,0));
    }
}
