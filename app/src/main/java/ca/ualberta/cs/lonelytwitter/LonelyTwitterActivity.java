package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small, personal Twitter app to capture notes, and comments.
 * <p>It saves the input tweets in json files.</p>
 * @since 1.2.1
 * @see LonelyTwitterActivity fore more information.
 */
public class LonelyTwitterActivity extends Activity {

	private final String GENERAL_FILE_NAME = "fileName.json";
	private static final String FILENAME = "file.sav";

	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;



	/**
	 * Calculates the size of a tweet
	 * @return number of characters in the tweet
	 */
	public int calculateTweetSize() {
		//
		return -1;
	}

	/**
	 * Removes a string from the body of the tweet
	 * @param text the text to be removed
	 * @return the new string.
	 */
	private String removeWords(String text) {
		//
		return "";
	}

	/**
	 * Starts the second activity
	 * @param intent the intent to be run after pressing the start button.
	 */
	private void startSecondActivity(Intent intent) {
		//

	}

	/**
	 *
	 * @param string
	 * @return
	 */
	public String someMethod(String string) {
		//
		return "";
	}

	/**
	 * Evaluates the second activity
	 * @param intent
	 * @return
	 */
	public boolean evaluateSecondActivity(Intent intent) {
		//
		Intent intent1 = new Intent();
		startSecondActivity(intent1);

		String expression1 = "", expression2 = "", expression3 = "",
				expression4 = "";

		String temp = someMethod(expression1 + expression2 + expression3
				+ expression4);
		try {
			int a = 1;
			int b = 2;
			if(a < 2) {
				someMethod("First choice");
			} else {
				someMethod("Second choice");
			}
			while (true) {
				int j = 0;
			}
		} catch (Exception e) {
			return true;
		}
	}
	
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				try{

					NormalTweet tweet = new NormalTweet(text);
					tweets.add(tweet);

				} catch (TweetTooLongException ex) {
					Toast.makeText(LonelyTwitterActivity.this,"Tweet was too long!",Toast.LENGTH_SHORT).show();

				}
				bodyText.setText("");
				saveInFile();
				adapter.notifyDataSetChanged();

			}
		});

		Button clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				tweets.clear();
				File file = new File(getFilesDir(),FILENAME);
				if(file.exists()) file.delete();
				bodyText.setText("");
				adapter.notifyDataSetChanged();
			}
		});
	}

	/**
	 * Default android method
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,	R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Loads the json file to Arraylist
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			tweets.clear();
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {} .getType();
			tweets = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			tweets = new ArrayList<Tweet>();
		}
	}

	/**
	 * saves the arraylist to json file.
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}