package com.robbert36.littmeup;

import android.widget.ImageView;
import android.widget.TextView;

public interface State {

	public ImageView updateImageView(ImageView v);
	public TextView updateText(TextView v);
	public void updateLight(FlashLight light);
}
