package com.kaizen.scram.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import android.content.Context;
import android.os.Environment;

import com.kaizen.scram.R;
import com.kaizen.scram.concretes.DcimPathProvider;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileResourceFactory;
import com.kaizen.scram.interfaces.IPathProvider;

// http://developer.android.com/reference/android/os/Environment.html

@RunWith(PowerMockRunner.class)
@PrepareForTest({Environment.class, Context.class})
public class TestDcimPathProvider {
	
	@Test
	public void path_void_dcimPlusAppName() throws Exception {
		// Arrange
		mockStatic(Environment.class);
		File dcim_path = new File("/dcim_path");
		when(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM))
			.thenReturn(dcim_path);
		
		Context context = mock(Context.class);
		String app_name = "app_name";
		when(context.getString(R.string.app_name))
			.thenReturn(app_name);
		
		IFileResourceFactory factory = mock(IFileResourceFactory.class);
		String filename = "test";
		File expected_path = new File(new File(dcim_path, app_name), filename);
		IFileResource file_resource = mock(IFileResource.class);
		when(file_resource.getFile())
			.thenReturn(expected_path);
		when(factory.create(expected_path))
			.thenReturn(file_resource);
		
		// Act
		IPathProvider path_provider = new DcimPathProvider(context, factory);
		
		// Assert
		
		assertEquals(expected_path.getAbsolutePath(), path_provider.resource(filename).getFile().getAbsolutePath());
		verifyStatic();
		Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		verify(context).getString(R.string.app_name);
	}
	
}
