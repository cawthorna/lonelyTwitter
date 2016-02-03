package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cawthorn on 1/12/16.
 */
public interface Tweetable {

    /**
     * @see #getMessage()
     * @return
     */
    public String getMessage();

    /**
     * @see #getDate()
     * @return
     */
    public Date getDate();

}
