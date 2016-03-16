package ca.ualberta.cs.lonelytwitter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;

import io.searchbox.annotations.JestId;

public abstract class Tweet {
    @JestId
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected Date date;
    protected String message;

    protected transient Bitmap thumbnail;
    protected String thumbnailBase64;

    public Tweet(Date date, String message, Bitmap thumbnail) {
        this.date = date;
        this.message = message;
        this.thumbnail = thumbnail;
    }

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public Bitmap getThumbnail() {
        if(thumbnail == null && thumbnailBase64 != null) {
            byte[] b = Base64.decode(thumbnailBase64, Base64.DEFAULT);
            thumbnail = BitmapFactory.decodeByteArray(b, 0, b.length);
        }
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        if(thumbnail != null) {
            this.thumbnail = thumbnail;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            byte[] b = outputStream.toByteArray();
            thumbnailBase64 = Base64.encodeToString(b, Base64.DEFAULT);
        }
    }

    @Override
    public String toString() {
        // Some people thought they would be funny and add tweets without dates...
        if(date == null) {
            if(message == null) {
                return "";
            } else {
                return message;
            }
        }
        return date.toString() + " | " + message;
    }
}
