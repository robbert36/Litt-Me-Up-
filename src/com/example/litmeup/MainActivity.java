package com.example.litmeup;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	private StateMachine stateMachine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		stateMachine = new StateMachine(this);

        setContentView(R.layout.activity_main);

        ImageView imageview = (ImageView) findViewById(R.id.lit_image);
		imageview.setImageResource(R.drawable.unlit);
		
		ImageButton button = (ImageButton) findViewById(R.id.power_button);
		button.setImageResource(R.drawable.power_button);
		button.setOnClickListener(new OnClickListener() {
						
			@Override
			public void onClick(View v) {
				System.out.println("Click");
				stateMachine.toggleState();
			}
		});		
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
