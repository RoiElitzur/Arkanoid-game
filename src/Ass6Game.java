import General.AnimationRunner;
import General.GameFlow;
import Interfaces.LevelInformation;
import Levels.DirectHit;
import Levels.Green3;
import Levels.WideEasy;
import Levels.FinalFour;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;
/**
 * This class initialize and run the game.
 */
public class Ass6Game {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int NUMBER_OF_LEVELS = 4;
    /**
     * This is the main method of the class.
     * @param args The srting array from the command line.
     */
    public static void main(String[] args) {
        LevelInformation[] levelOptions = new LevelInformation[NUMBER_OF_LEVELS];
        levelOptions[0] = new DirectHit();
        levelOptions[1] = new WideEasy();
        levelOptions[2] = new Green3();
        levelOptions[3] = new FinalFour();
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        AnimationRunner animationRunner = new AnimationRunner(gui);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        List<LevelInformation> levelsArr = new ArrayList<>();
        int count = 0;
        for (String str : args) {
            if (str.equals("1")) {
                levelsArr.add(levelOptions[0]);
            } else if (str.equals("2")) {
                levelsArr.add(levelOptions[1]);
            } else if (str.equals("3")) {
                levelsArr.add(levelOptions[2]);
            } else if (str.equals("4")) {
                levelsArr.add(levelOptions[3]);
            } else {
                count++;
            }
        }
        if (args.length == count) {
            levelsArr.add(new DirectHit());
            levelsArr.add(new WideEasy());
            levelsArr.add(new Green3());
            levelsArr.add(new FinalFour());
        }
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor);
        gameFlow.runLevels(levelsArr);
    }
}
