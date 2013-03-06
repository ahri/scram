package com.kaizen.scram.concretes;

import java.io.IOException;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;

import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.ICameraCallbackFactory;
import com.kaizen.scram.interfaces.IFileResource;

public class CameraAdapter implements ICameraAdapter {

	private final SurfaceTexture surface;
	private final ICameraCallbackFactory callback_factory;

	public CameraAdapter(SurfaceTexture surface, ICameraCallbackFactory callback_factory) {
		this.surface = surface;
		this.callback_factory = callback_factory;
	}

	@Override
	public void shoot(IFileResource file_resource) throws IOException {
		Camera camera = Camera.open();
		//camera.setPreviewDisplay(this.surface);
		camera.setPreviewTexture(this.surface);
		camera.startPreview();
		camera.takePicture(null, null, this.callback_factory.create(file_resource));
		camera.stopPreview();
		camera.release();
	}

}
