package General;
public class Counter {
    private int counter;
    static final int ZERO = 0;
    /**
     * This is a constructor method to initiate a Counter object.
     */
    public Counter() {
        this.counter = ZERO;
    }
    /**
     * This method adds number to current count.
     * @param number int type.
     */
    public void increase(int number) {
        this.counter += number;
    }
    /**
     * This method subtracts number from current count.
     * @param number int type.
     */
     public void decrease(int number) {
        this.counter -= number;
    }
    /**
     * This is a getter method to get the current count.
     * @return The current count, int type.
     */
    public int getValue() {
        return this.counter;
    }
    /**
     * This is a setter method to set the value of the counter.
     * @param number int type.
     */
    public void setValue(int number) {
        this.counter = number;
    }

}