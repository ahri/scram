package com.kaizen.scram.concretes;

import java.io.File;
import java.io.FileNotFoundException;

import android.content.Context;
import android.os.Environment;

import com.kaizen.scram.R;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileResourceFactory;
import com.kaizen.scram.interfaces.IPathProvider;

public class DcimPathProvider implements IPathProvider {
	
	private final Context context;
	private final IFileResourceFactory resource_factory;

	public DcimPathProvider(Context context, IFileResourceFactory resource_factory) {
		this.context = context;
		this.resource_factory = resource_factory;
	}

	private File path() {
		File dcim_dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		return new File(dcim_dir, this.context.getString(R.string.app_name));
	}

	@Override
	public IFileResource resource(String filename) throws FileNotFoundException {
		return this.resource_factory.create(new File(this.path(), filename));
	}

}
