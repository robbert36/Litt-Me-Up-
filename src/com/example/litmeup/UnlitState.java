package com.example.litmeup;

import android.widget.ImageView;
import android.widget.TextView;

public class UnlitState implements State {
		private int mImageRecourse = R.drawable.unlit;
		
	public UnlitState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageView updateImageView(ImageView v) {
		v.setImageResource(mImageRecourse);
		return v;
	}

	@Override
	public TextView updateText(TextView v) {
		return null;
	}

	@Override
	public void updateLight(FlashLight light) {
		light.off();
	}

}
