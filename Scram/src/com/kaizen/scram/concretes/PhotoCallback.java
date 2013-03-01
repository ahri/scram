package com.kaizen.scram.concretes;

import android.hardware.Camera;

import com.kaizen.scram.interfaces.IGetPictureData;

public class PhotoCallback implements Camera.PictureCallback, IGetPictureData {

	@Override
	public byte[] getPictureData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		// TODO Auto-generated method stub
		
	}

}
