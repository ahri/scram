package com.kaizen.scram.test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.kaizen.scram.concretes.FileResource;
import com.kaizen.scram.interfaces.IFileOutputStreamFactory;
import com.kaizen.scram.interfaces.IFileResource;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FileOutputStream.class})
public class TestFileResource {

	@Test
	public void getFile_mockInConstruction_mockFile() throws Exception {
		// Arrange
		File f = mock(File.class);
		File p = mock(File.class);
		when(f.getParentFile())
			.thenReturn(p);
		
		IFileOutputStreamFactory fos_factory = mock(IFileOutputStreamFactory.class);
		FileOutputStream s = mock(FileOutputStream.class);
		when(fos_factory.create(f))
			.thenReturn(s);
		
		// Act
		IFileResource fr = new FileResource(f, fos_factory);
		
		//Assert
		assertSame(f, fr.getFile());
	}
	
	@Test
	public void getStream_mockInConstruction_mockStream() throws Exception {
		// Arrange
		File f = mock(File.class);
		File p = mock(File.class);
		when(f.getParentFile())
			.thenReturn(p);
		when(p.mkdirs())
			.thenReturn(true);
		
		IFileOutputStreamFactory fos_factory = mock(IFileOutputStreamFactory.class);
		FileOutputStream s = mock(FileOutputStream.class);
		when(fos_factory.create(f))
			.thenReturn(s);
		
		// Act
		IFileResource fr = new FileResource(f, fos_factory);
		
		//Assert
		assertSame(s, fr.getStream());
		verify(f).getParentFile();
		verify(p).mkdirs();
	}
}
