package Interfaces;
public interface HitNotifier {
    /**
     *  This method adds hl as a listener to hit events.
     * @param hl HitListener type.
     */
    void addHitListener(HitListener hl);
    /**
     * This method removes hl from the list of listeners to hit events.
     * @param hl HitListener.
     */
    void removeHitListener(HitListener hl);
}
