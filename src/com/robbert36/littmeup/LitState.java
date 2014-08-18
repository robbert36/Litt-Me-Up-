package com.robbert36.littmeup;

import android.widget.ImageView;
import android.widget.TextView;

public class LitState implements State {
	private int mImageRecourse = R.drawable.lit_up;
	private String mText = "You just got litt up!!!";

	public LitState() {

	}

	@Override
	public ImageView updateImageView(ImageView v) {
		v.setImageResource(mImageRecourse);
		return v;
	}

	@Override
	public TextView updateText(TextView v) {
		v.setText(mText);
		return v;
	}

	@Override
	public void updateLight(FlashLight light) {
		light.on();
	}

}
