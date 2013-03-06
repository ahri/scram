package com.kaizen.scram.test;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import android.os.Environment;

import com.kaizen.scram.concretes.ExternalFileWriterAdapter;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileWriterAdapter;

// http://developer.android.com/reference/android/os/Environment.html

@RunWith(PowerMockRunner.class)
@PrepareForTest({Environment.class, File.class, FileOutputStream.class})
public class TestExternalFileWriter {
	
	@Test
	public void write_data_fsInteractions() throws Exception {
		// Arrange
		mockStatic(Environment.class);
		when(Environment.getExternalStorageState())
			.thenReturn(Environment.MEDIA_MOUNTED);
		
		IFileResource file_resource = mock(IFileResource.class);
		File full_target_file = mock(File.class);
		FileOutputStream stream = mock(FileOutputStream.class);
		/*when(full_target_file.mkdirs())
			.thenReturn(true);*/
		when(file_resource.getFile())
			.thenReturn(full_target_file);
		when(file_resource.getStream()).thenReturn(stream);
		
		byte[] data = "test".getBytes();
		doNothing()
			.when(stream)
			.write(data);
		
		// Act
		IFileWriterAdapter writer = new ExternalFileWriterAdapter();
		writer.write(file_resource, data);
		
		// Assert
		verifyStatic();
		Environment.getExternalStorageState();
		//verify(full_target_file).mkdirs();
		verify(stream).write(data);
		verify(stream).close();
	}
	
}
