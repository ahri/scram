package com.kaizen.scram.factories;

import android.hardware.Camera;

import com.kaizen.scram.concretes.CameraCallback;
import com.kaizen.scram.interfaces.ICameraCallbackFactory;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileWriterAdapter;

public class CameraCallbackFactory implements ICameraCallbackFactory {
	
	private final IFileWriterAdapter writer;

	public CameraCallbackFactory(IFileWriterAdapter writer) {
		this.writer = writer;
	}

	@Override
	public Camera.PictureCallback create(IFileResource file_resource) {
		return new CameraCallback(file_resource, this.writer);
	}
	
}
