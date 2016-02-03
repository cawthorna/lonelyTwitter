package ca.ualberta.cs.lonelytwitter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public abstract class Mood {

    protected Date date;

    /**
     * returns the string representation of the mood
     * @return the string representation of the mood
     */
    public abstract String getMood();

    /**
     * Default Constructor
     */
    public Mood() {
        setDate(Calendar.getInstance().getTime());
    }

    /**
     * Constructor with specified date
     * @param date
     */
    public Mood(Date date) {
        setDate(date);
    }

    /**
     * returns the date.
     * @return date in the format java.util.Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date.
     * @param date in the form java.util.Date to set the date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
