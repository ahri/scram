package com.kaizen.scram.test;

import static org.junit.Assert.*;

import org.junit.Test;

import android.hardware.Camera;

import com.kaizen.scram.concretes.*;
import com.kaizen.scram.interfaces.*;

import static org.mockito.Mockito.*;

public class TestPhotoCallback {

	@Test
	public void onPictureTaken_callWorks() {
		Camera.PictureCallback callback = new PhotoCallback();
		byte[] data = "test".getBytes();
		callback.onPictureTaken(data, mock(Camera.class));
	}
	
	@Test
	public void getPictureData_beforeCallback_null() {
		IGetPictureData callback = new PhotoCallback();
		assertNull(callback.getPictureData());
	}
	
	@Test
	public void getPictureData_afterCallback_data() {
		PhotoCallback callback = new PhotoCallback();
		byte[] data = "test".getBytes();
		
		callback.onPictureTaken(data, mock(Camera.class));
		
		assertArrayEquals(data, callback.getPictureData());
	}

}
