package com.kaizen.scram.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

//import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.kaizen.scram.concretes.*;
import com.kaizen.scram.interfaces.*;

import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Camera.class})
public class TestCameraAdapter {

	@Test
	public void shoot_void_Photo() throws IOException {
		Camera camera = mock(Camera.class);
		SurfaceHolder surface = mock(SurfaceHolder.class);
		Camera.PictureCallback callback = mock(Camera.PictureCallback.class);
		
		doNothing().when(camera).setPreviewDisplay(surface);
		doNothing().when(camera).startPreview();
		doNothing().when(camera).takePicture(null, null, callback);
		
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
