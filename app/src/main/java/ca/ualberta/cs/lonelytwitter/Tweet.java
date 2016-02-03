package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public abstract class Tweet implements Tweetable, Comparable<Tweet> {

    private Date date;
    private String message;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    public abstract boolean isImportant();

    /**
     *
     * @param date
     * @param message
     * @param mood
     * @throws TweetTooLongException
     */
    public Tweet(Date date, String message, Mood mood) throws TweetTooLongException{
        setDate(date);
        setMessage(message);
        addMood(mood);
    }

    /**
     *
     * @param date
     * @param message
     * @throws TweetTooLongException
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
        setDate(date);
        setMessage(message);
    }

    /**
     *
     * @param message
     * @throws TweetTooLongException
     */
    public Tweet(String message) throws TweetTooLongException {
        setDate(Calendar.getInstance().getTime());
        setMessage(message);
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() < 140) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }

    /**
     *
     * @param mood
     */
    public void addMood(Mood mood) {
        moods.add(mood);
    }

    /**
     *
     * @return
     */
    public ArrayList<Mood> getMoods() {
        return moods;
    }

    /**
     *
     * @param tweet
     * @return
     */
    public int compareTo(Tweet tweet) {
        return this.getDate().compareTo(tweet.getDate());
    }

}
