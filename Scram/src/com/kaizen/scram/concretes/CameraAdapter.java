package com.kaizen.scram.concretes;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.IGetPictureData;
import com.kaizen.scram.interfaces.IPhoto;

public class CameraAdapter implements ICameraAdapter {

	public <T extends Camera.PictureCallback & IGetPictureData> CameraAdapter(Camera camera, SurfaceHolder surface, T callback) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPhoto shoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
