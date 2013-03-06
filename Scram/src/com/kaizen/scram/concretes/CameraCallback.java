package com.kaizen.scram.concretes;

import java.io.IOException;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.util.Log;

import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileWriterAdapter;

public class CameraCallback implements PictureCallback {

	private final IFileResource file_resource;
	private final IFileWriterAdapter writer;

	public CameraCallback(IFileResource file_resource, IFileWriterAdapter writer) {
		this.file_resource = file_resource;
		this.writer = writer;
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		try {
			writer.write(this.file_resource, data);
		} catch (IOException e) {
			// TODO: handle?
			Log.e(this.getClass().getName(), e.getMessage());
		}
	}

}
