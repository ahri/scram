package com.kaizen.scram.concretes;

import java.io.IOException;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.ICameraCallbackFactory;
import com.kaizen.scram.interfaces.IFileResource;

public class CameraAdapter implements ICameraAdapter {

	private final SurfaceHolder surface;
	private final ICameraCallbackFactory callback_factory;

	public CameraAdapter(SurfaceHolder surface, ICameraCallbackFactory callback_factory) {
		this.surface = surface;
		this.callback_factory = callback_factory;
	}

	@Override
	public void shoot(IFileResource file_resource) throws IOException {
		Camera camera = Camera.open();
		try {
			camera.setPreviewDisplay(this.surface);
			camera.startPreview();
			camera.takePicture(null, null, this.callback_factory.create(file_resource));
			camera.stopPreview();
		} finally {
			camera.release();
			camera = null;
		}
	}

}
