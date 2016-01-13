package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    public abstract boolean isImportant();

    public Tweet(Date date, String message, Mood mood) throws TweetTooLongException{
        setDate(date);
        setMessage(message);
        addMood(mood);
    }

    public Tweet(Date date, String message) throws TweetTooLongException {
        setDate(date);
        setMessage(message);
    }

    public Tweet(String message) throws TweetTooLongException {
        setDate(Calendar.getInstance().getTime());
        setMessage(message);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() < 140) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public void addMood(Mood mood) {
        moods.add(mood);
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }

}
