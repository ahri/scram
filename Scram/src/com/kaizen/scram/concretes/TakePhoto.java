package com.kaizen.scram.concretes;

import java.io.IOException;

import android.util.Log;

import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IRunnable;

public class TakePhoto implements IRunnable {

	private final ICameraAdapter camera;
	private final IFileResource file_resource;

	public TakePhoto(ICameraAdapter camera, IFileResource file_resource) {
		this.camera = camera;
		this.file_resource = file_resource;
	}

	@Override
	public void run() {
		try {
			this.camera.shoot(this.file_resource);
		} catch (IOException e) {
			// TODO: handle?
			Log.e(this.getClass().getName(), e.getMessage());
		}
	}

}
