package General;
import Interfaces.LevelInformation;
import biuoop.KeyboardSensor;
import java.util.List;
/**
 * This is the GameFlow class.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private Counter balls;
    private Counter blocks;
    /**
     * This is a constructor method to initiate the GameFlow object.
     * @param ar AnimationRunner type.
     * @param ks KeyboardSensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.balls = new Counter();
        this.score = new Counter();
        this.blocks = new Counter();
    }
    /**
     * This method gets a list of levels information and runs them
     * according to the player success.
     * @param levels List<LevelInformation> type.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            this.balls.setValue(levelInfo.numberOfBalls());
            this.blocks.setValue(levelInfo.numberOfBlocksToRemove());
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner,
                    this.score, this.blocks, this.balls);
            level.initialize();
            while (this.balls.getValue() > 0 && this.blocks.getValue() > 0) {
                level.run();
            }
            if (this.balls.getValue() == 0) {
                break;
            }

        }
        EndScreen endScreen = new EndScreen(this.keyboardSensor, this.balls, this.score);
        KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(
                this.keyboardSensor, "space", endScreen, this.animationRunner.getGui());
        this.animationRunner.run(keyPressStoppableAnimation);
        this.animationRunner.getGui().close();
    }
}

