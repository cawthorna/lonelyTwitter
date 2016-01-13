package ca.ualberta.cs.lonelytwitter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class Sad extends Mood {
    public Sad() {
        super(Calendar.getInstance().getTime());
    }

    public Sad(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        return "Sad :(";
    }
}
