package com.kaizen.scram.interfaces;

import android.hardware.Camera;

public interface ICameraCallbackFactory {

	public Camera.PictureCallback create(IFileResource file_resource);

}