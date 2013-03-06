package com.kaizen.scram.test;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.kaizen.scram.concretes.CameraAdapter;
import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.ICameraCallbackFactory;
import com.kaizen.scram.interfaces.IFileResource;

// http://developer.android.com/reference/android/hardware/Camera.html

@RunWith(PowerMockRunner.class)
@PrepareForTest({Camera.class})
public class TestCameraAdapter {

	@Test
	public void shoot_void_cameraInteractions() throws IOException {
		// Arrange
		Camera camera = mock(Camera.class);
		SurfaceHolder surface = mock(SurfaceHolder.class);
		Camera.PictureCallback callback = mock(Camera.PictureCallback.class);
		ICameraCallbackFactory factory = mock(ICameraCallbackFactory.class);
		IFileResource file_resource = mock(IFileResource.class);
		when(factory.create(file_resource))
			.thenReturn(callback);
		doNothing()
			.when(camera).setPreviewDisplay(surface);
		doNothing()
			.when(camera).startPreview();
		doNothing()
			.when(camera).takePicture(null, null, callback);
		
		mockStatic(Camera.class);
		when(Camera.open()).thenReturn(camera);
		
		// Act
		ICameraAdapter camera_adapter = new CameraAdapter(surface, factory);
		camera_adapter.shoot(file_resource);
		
		// Assert
		verifyStatic();
		Camera.open();
		verify(camera).setPreviewDisplay(surface);
		verify(camera).startPreview();
		verify(camera).takePicture(null, null, callback);
		verify(camera).stopPreview();
		verify(camera).release();
	}

}
