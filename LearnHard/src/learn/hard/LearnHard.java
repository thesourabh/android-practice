package learn.hard;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class LearnHard extends Activity {
	WebView tutorialView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn_hard);
		tutorialView = (WebView) findViewById(R.id.wvTutorial);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle state) {
		super.onRestoreInstanceState(state);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.learn_hard, menu);
		return true;
	}

	public void changeTutorial(View v) {
		double randomValue = Math.random();
		if (randomValue < 0.25)
			tutorialView.loadUrl("http://learnpythonthehardway.org/book/");
		else if (randomValue < 0.50)
			tutorialView.loadUrl("http://ruby.learncodethehardway.org/book/");
		else if (randomValue < 0.75)
			tutorialView.loadUrl("http://regex.learncodethehardway.org/book/");
		else
			tutorialView.loadUrl("http://sql.learncodethehardway.org/book/");
	}

}
