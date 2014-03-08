package nasa.war.jabber.roundball;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class Jabberwocky extends Activity {
	WebView jabbView;
	MediaPlayer jabSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jabberwocky);
		jabSong = MediaPlayer.create(this, R.raw.jabberwocky);
		jabSong.setLooping(true);
		jabSong.start();
		jabbView = (WebView) findViewById(R.id.wvJabberwocky);
		jabbView.loadUrl("file:///android_asset/jabberwocky.html");
	}
	
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && jabbView.canGoBack()) {
	        jabbView.goBack();
	        return true;
	    }
		return super.onKeyDown(keyCode, event);
	}



	@Override
	protected void onPause() {
		jabSong.stop();
		jabSong.release();
		jabSong = null;
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		jabSong = MediaPlayer.create(this, R.raw.jabberwocky);
		jabSong.setLooping(true);
		jabSong.start();
		super.onResume();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}
	public void loadWikipedia(View v) {
		Intent wikintent = new Intent(Intent.ACTION_VIEW);
		wikintent.setData(Uri.parse("http://en.wikipedia.org/wiki/Jabberwocky"));
		startActivity(wikintent);
	}
	public void loadImage(View v) {
		jabbView.loadUrl("file:///android_asset/jabberwocky.jpg");
	}

}
