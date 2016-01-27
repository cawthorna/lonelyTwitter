package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cawthorn on 1/26/16.
 *
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAdd() {
        TweetList tweets = new TweetList();
        try {
            Tweet tweet = new NormalTweet("Test Tweet");
            tweets.add(tweet);
            assertTrue(tweets.hasTweet(tweet));

            tweets.add(tweet);
            fail();

        } catch (TweetTooLongException ex) {

        } catch (IllegalArgumentException ex) {
            // should be here.
        }

    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        try {
            Tweet tweet = new NormalTweet("Test Tweet");

            assertFalse(tweets.hasTweet(tweet));

            tweets.add(tweet);
            assertTrue(tweets.hasTweet(tweet));
        } catch (TweetTooLongException ex) {}
    }

    public void testGetTweet() {

        TweetList tweets = new TweetList();
        try {
            Tweet tweet = new NormalTweet("Test Tweet");
            tweets.add(tweet);

            Tweet returnedTweet = tweets.getTweet(0);

            assertEquals(returnedTweet.getMessage(), tweet.getMessage());
            assertEquals(returnedTweet.getDate(), tweet.getDate());
            assertEquals(returnedTweet, tweet);

        } catch (TweetTooLongException ex) {}

    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        try {
            Tweet tweet = new NormalTweet("Test Tweet");
            tweets.add(tweet);

            Tweet returnedTweet = tweets.getTweet(0);

            assertEquals(returnedTweet.getMessage(), tweet.getMessage());
            assertEquals(returnedTweet.getDate(), tweet.getDate());
            assertEquals(returnedTweet, tweet);

            Tweet earlyTweet = new NormalTweet(new Date(System.currentTimeMillis()-100000), "Early Tweet");
            tweets.add(earlyTweet);

            ArrayList<Tweet> returnedTweets = tweets.getTweets();
            assertEquals(returnedTweets.get(0).getMessage(), earlyTweet.getMessage());
            assertEquals(returnedTweets.get(0).getDate(), earlyTweet.getDate());
            assertEquals(returnedTweets.get(1).getDate(), tweet.getDate());
            assertEquals(returnedTweets.get(1).getMessage(), tweet.getMessage());

        } catch (TweetTooLongException ex) {}
    }

    public void testRemoveTweet() {

        TweetList tweets = new TweetList();
        try {
            Tweet tweet = new NormalTweet("Test Tweet");
            tweets.add(tweet);

            tweets.removeTweet(tweet);
            assertFalse(tweets.hasTweet(tweet));


        } catch (TweetTooLongException ex) {}

    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        try {
            Tweet tweet = new NormalTweet("Test Tweet");
            tweets.add(tweet);

            assertEquals(tweets.getCount(), 1);


        } catch (TweetTooLongException ex) {}

    }
}
