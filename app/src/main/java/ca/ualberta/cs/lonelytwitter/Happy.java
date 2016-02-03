package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class Happy extends Mood {

    /**
     * @see Mood
     * @param date
     */
    public Happy(Date date) {
        super(date);
    }

    /**
     * @see Mood
     */
    public Happy() {
        super();
    }

    /**
     * @see #getMood()
     * @return string representation of the mood
     */
    @Override
    public String getMood() {
        return "Happy :)";
    }
}
