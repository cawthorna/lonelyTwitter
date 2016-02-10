package ca.ualberta.cs.lonelytwitter;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sajediba on 2/8/16.
 */
public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2{

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    //
    //
    public void testSendText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 1");

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity) getActivity();

        assertEquals("IntentReaderActivity should get the text from intent" ,
                "message 1", ira.getText());

    }

    public void testDisplayText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 2");

        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        TextView textView = (TextView) intentReaderActivity.findViewById(R.id.intentText);
        assertEquals("The text should be displayed!", "message 2",
                textView.getText().toString());

    }

    public void testDoubleText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 3");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
                IntentReaderActivity.DOUBLE);

        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        assertEquals("The text should be repeated twice!", "message 3message 3",
                intentReaderActivity.getText());
    }
    //
    //

    //TODO: Add your code here ...
//-------------------------------------------------------------------------------

    public void testReverseText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 4");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
                IntentReaderActivity.REVERSE);

        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        assertEquals("The text should be reversed!", "4 egassem",
                intentReaderActivity.getText());
    }

    public void testDefaultMessage() {
        Intent intent = new Intent();

        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        assertEquals("The message should be \"Default test\"", "Default test",
                intentReaderActivity.getText());
    }

    public void testTextViewOnScreen() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 5");

        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        final View view =
                intentReaderActivity.getWindow().getDecorView().findViewById(R.id.intentText);
        ViewAsserts.assertOnScreen(intentReaderActivity.findViewById(R.id.intentText), view);
    }

//-------------------------------------------------------------------------------
}
