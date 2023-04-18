package General;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private AnimationRunner animationRunner;
    private boolean isAlreadyPressed;
    /**
     * This is a constructor method to initiate the KeyPressStoppableAnimation object.
     * @param sensor KeyboardSensor type.
     * @param key String type.
     * @param animation Animation type.
     * @param gui GUI type.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation, GUI gui) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.animationRunner = new AnimationRunner(gui);
        this.isAlreadyPressed = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(this.key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        }
        isAlreadyPressed = false;
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}