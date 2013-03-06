package com.kaizen.scram.test;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import android.hardware.Camera;

import com.kaizen.scram.concretes.CameraCallback;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileWriterAdapter;

// http://developer.android.com/reference/android/hardware/Camera.html

public class TestCameraCallback {

	@Test
	public void shoot_void_cameraInteractions() throws IOException {
		// Arrange
		IFileResource file_resource = mock(IFileResource.class);
		File file = mock(File.class);
		FileOutputStream stream = mock(FileOutputStream.class);
		when(file_resource.getFile())
			.thenReturn(file);
		when(file_resource.getStream())
			.thenReturn(stream);
		
		
		IFileWriterAdapter writer = mock(IFileWriterAdapter.class);
		byte[] data = "test".getBytes();
		doNothing()
			.when(writer)
			.write(file_resource, data);
		
		Camera camera = mock(Camera.class);
		
		Camera.PictureCallback callback = new CameraCallback(file_resource, writer);
		
		// Act
		callback.onPictureTaken(data, camera);
		
		// Assert
		verify(writer).write(file_resource, data);
	}

}
