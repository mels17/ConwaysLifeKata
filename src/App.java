import main.Game;
import main.Printer;
import main.World;

public class App {

    public static void main(String[] args) throws InterruptedException {
        World world = new World(new boolean[][]{
                new boolean[]{false, false, false, true},
                new boolean[]{true, true, false, true},
                new boolean[]{false, false,true, false},
                new boolean[]{true, false, false, true},
                new boolean[]{true, true, true, true},
                new boolean[]{false, false,true, false},
                new boolean[]{true, false, false, true},
                new boolean[]{true, true, true, true},
                new boolean[]{false, false,true, false},

        });
        Printer printer = new Printer();
        Game game = new Game(world, printer);
        game.display(game.run(10));
    }
}
