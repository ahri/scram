package com.kaizen.scram.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Test;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.kaizen.scram.concretes.*;
import com.kaizen.scram.interfaces.*;

public class TestCameraAdapter {

	@Test
	public void shoot_void_Photo() throws IOException {
		// dependencies
		Camera camera = mock(Camera.class);
		SurfaceHolder surface = mock(SurfaceHolder.class);
		PhotoCallback callback = mock(PhotoCallback.class);
		
		// item under test
		ICameraAdapter camera_adapter = new CameraAdapter(camera, surface, callback);
		
		IPhoto photo = camera_adapter.shoot();
		
		// http://developer.android.com/reference/android/hardware/Camera.html
		verify(camera).setPreviewDisplay(surface);
		verify(camera).startPreview();
		verify(camera).takePicture(null, null, callback);
		
		assertSame(photo, photo);
	}

}
