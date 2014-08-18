package com.robbert36.littmeup;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

public class StateMachine {

	private State[] states = { new UnlitState(), new LitState() };
	private int current;
	private Context mcontext;
	private FlashLight mflashlight;

	static private final int UNLIT_STATE = 0;
	static private final int LIT_STATE = 1;

	public StateMachine(Context context) {
		mcontext = context;
		current = UNLIT_STATE;
		mflashlight = new FlashLight(mcontext);
	}

	public State getState() {
		return states[current];
	}

	public void update() {
		ImageView iv;
		State s;
		Activity a;

		s = getState();

		// Update Flashlight
		s.updateLight(mflashlight);

		// Update image
		a = (MainActivity) mcontext;
		iv = (ImageView) a.findViewById(R.id.lit_image);
		iv = s.updateImageView(iv);
	}

	public void toggleState() {
		System.out.println("Toggle state");
		current = (++current) % states.length;
		update();
	}
}
