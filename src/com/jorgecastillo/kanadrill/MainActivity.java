package com.jorgecastillo.kanadrill;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private SharedPreferences myPreferences;
	private Context myContext;
	private String textToast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myContext = getApplicationContext();
		myPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		if (!myPreferences.getBoolean("setup_true", false)){
			
			SharedPreferences.Editor editMyPreferences = myPreferences.edit();
			editMyPreferences.putBoolean("setup_true", true);
			editMyPreferences.commit();
			
			textToast = "Setup the app";
			Toast.makeText(myContext, textToast, Toast.LENGTH_SHORT).show();
			
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);

		}
		
	}

	public void onClickButtonTrain(View view){
	  
		Intent intent = new Intent(this, TrainingActivity.class);
		startActivity(intent);
		
	}
	
	public void onClickButtonStart(View view){
		  
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
