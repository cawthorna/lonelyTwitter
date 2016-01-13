package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class NormalTweet extends Tweet {

    public NormalTweet(Date date, String message, Mood mood) throws TweetTooLongException{
        super(date, message, mood);
    }

    public NormalTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    @Override
    public boolean isImportant() {
        return false;
    }


}
