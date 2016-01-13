package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class Happy extends Mood {

    public Happy(Date date) {
        super(date);
    }

    public Happy() {
        super();
    }

    @Override
    public String getMood() {
        return "Happy :)";
    }
}
