package ca.ualberta.cs.lonelytwitter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public abstract class Mood {

    protected Date date;

    public abstract String getMood();

    public Mood() {
        setDate(Calendar.getInstance().getTime());
    }

    public Mood(Date date) {
        setDate(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
