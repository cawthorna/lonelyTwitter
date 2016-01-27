package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cawthorn on 1/26/16.
 *
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {

        if(hasTweet(tweet)) throw new IllegalArgumentException("The tweet is already in there");
        tweets.add(tweet);

    }

    public boolean hasTweet(Tweet tweet) {

        return tweets.contains(tweet);

    }

    public Tweet getTweet(int index) throws TweetTooLongException {

        return tweets.get(index);

    }

    public void removeTweet(Tweet tweet) {

        tweets.remove(tweet);

    }

    public int getCount() {
        return 1;
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }




}
