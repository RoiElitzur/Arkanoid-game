package General;
import Interfaces.Sprite;
import java.util.ArrayList;
import biuoop.DrawSurface;
/**
 * This is the SpriteCollection class.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;
    /**
     * This is a constructor method to initiate a Sprite object.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }
    /**
     * This method adds a Sprite object to the sprites array list.
     * @param s Sprite type.
     */
    public void addSprite(Sprite s) {
        if (this.sprites == null) {
            this.sprites = new ArrayList<Sprite>();
        }
        this.getSprites().add(s);
    }
    /**
     * This method removes a Sprite object from the sprites array list.
     * @param s Sprite type.
     */
    public void removeSprite(Sprite s) {
        if (this.sprites != null) {
            this.sprites.remove(s);
        }
        return;
    }
    /**
     *This method calls timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        ArrayList<Sprite> sprites = new ArrayList<Sprite>(this.getSprites());
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }
    }
    /**
     * This method calls drawOn(d) on all sprites.
     * @param d DrawSurface type.
     */
    public void drawAllOn(DrawSurface d) {
        ArrayList<Sprite> sprites = this.getSprites();
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
    /**
     * This is a getter method to get the sprites array list.
     * @return the sprites array list.
     */
    public ArrayList<Sprite> getSprites() {
        return this.sprites;
    }
}