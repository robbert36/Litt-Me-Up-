package com.robbert36.littmeup;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;

public class FlashLight {
	private Context mcontext;
	boolean hasFlashLight;
	boolean on = false;
	Camera cam;

	public FlashLight(Context context) {
		mcontext = context;
		hasFlashLight = context.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA_FLASH);
	}

	public void on() {
		if (hasFlashLight && !on) {
			cam = Camera.open();
			if (cam == null)
				return;
			Parameters p = cam.getParameters();
			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
			cam.setParameters(p);
			cam.startPreview();
			on = true;
		}
	}

	public void off() {
		if (hasFlashLight && on) {
			if (cam != null) {
				cam.stopPreview();
				cam.release();
				cam = null;
				on = false;
			}
		}
	}

}
