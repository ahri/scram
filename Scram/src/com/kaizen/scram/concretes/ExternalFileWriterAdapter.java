package com.kaizen.scram.concretes;

import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;

import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileWriterAdapter;

public class ExternalFileWriterAdapter implements IFileWriterAdapter {

	@Override
	public void write(IFileResource file_resource, byte[] data) throws IOException {
		if(!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// TODO: worry about lack of mounted storage
			Log.i(this.getClass().getName(), "No mounted storage");
			return;
		}
		
		//file_resource.getFile().mkdirs();
		FileOutputStream stream = file_resource.getStream();
		stream.write(data);
		stream.close();
	}

}
