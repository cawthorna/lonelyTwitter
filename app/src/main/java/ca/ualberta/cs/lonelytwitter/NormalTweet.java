package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class NormalTweet extends Tweet {

    /**
     * @see Tweet
     * @param date
     * @param message
     * @param mood
     * @throws TweetTooLongException
     */
    public NormalTweet(Date date, String message, Mood mood) throws TweetTooLongException{
        super(date, message, mood);
    }

    /**
     * @see Tweet
     * @param date
     * @param message
     * @throws TweetTooLongException
     */
    public NormalTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * @see Tweet
     * @param message
     * @throws TweetTooLongException
     */
    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * return if the tweet is an important tweet
     * @return false cause not important.
     */
    @Override
    public boolean isImportant() {
        return false;
    }


}
