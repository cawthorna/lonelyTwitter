package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(Date date, String message, Mood mood) throws TweetTooLongException{
        super(date, message, mood);
    }

    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    @Override
    public boolean isImportant() {
        return true;
    }

    @Override
    public String getMessage() {
        return "!IMPORTANT! " + this.getMessage();
    }
}
