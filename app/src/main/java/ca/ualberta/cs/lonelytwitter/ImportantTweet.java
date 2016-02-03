package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public class ImportantTweet extends Tweet {

    /**
     * @see Mood
     * @param date
     * @param message
     * @param mood
     * @throws TweetTooLongException
     */
    public ImportantTweet(Date date, String message, Mood mood) throws TweetTooLongException{
        super(date, message, mood);
    }

    /**
     * @see Mood
     * @param date
     * @param message
     * @throws TweetTooLongException
     */
    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * @see Mood
     * @param message
     * @throws TweetTooLongException
     */
    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * @see #isImportant()
     * @return true cause important
     */
    @Override
    public boolean isImportant() {
        return true;
    }

    /**
     * @see #getMessage()
     * @return
     */
    @Override
    public String getMessage() {
        return "!IMPORTANT! " + this.getMessage();
    }

}
