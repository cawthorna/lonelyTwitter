package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cawthorn on 1/26/16.
 *
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Adds to tweetlist
     * @param tweet tweet to be added
     */
    public void add(Tweet tweet) {

        if(hasTweet(tweet)) throw new IllegalArgumentException("The tweet is already in there");
        tweets.add(tweet);

    }

    /**
     * checks if the tweet is in the tweetlist.
     * @param tweet to check if in the list.
     * @return true if yes, false otherwise
     */
    public boolean hasTweet(Tweet tweet) {

        return tweets.contains(tweet);

    }

    /**
     * gets the tweet at the index
     * @param index of tweet to get
     * @return tweet gotten
     */
    public Tweet getTweet(int index) {

        return tweets.get(index);

    }

    /**
     * removes the tweet from the tweetlist
     * @param tweet to be removed
     */
    public void removeTweet(Tweet tweet) {

        tweets.remove(tweet);

    }

    /**
     * returns the number of tweets.
     * @return the number of tweets.
     */
    public int getCount() {
        return 1;
    }

    /**
     * Returns the tweetlist
     * @return the tweetlist
     */
    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }




}
