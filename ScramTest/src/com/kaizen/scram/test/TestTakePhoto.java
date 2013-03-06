package com.kaizen.scram.test;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import android.view.KeyEvent;

import com.kaizen.scram.concretes.TakePhoto;
import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IRunnable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({KeyEvent.class})
public class TestTakePhoto {

	@Test
	public void run_void_behaviour() throws IOException {
		// Arrange
		IFileResource file_resource = mock(IFileResource.class);
		ICameraAdapter camera = mock(ICameraAdapter.class);
		doNothing()
			.when(camera)
			.shoot(file_resource);
		
		IRunnable take_photo = new TakePhoto(camera, file_resource);
		
		// Act
		take_photo.run();
		
		// Assert
		verify(camera).shoot(file_resource);
	}

}
