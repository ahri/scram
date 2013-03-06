package com.kaizen.scram.concretes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.kaizen.scram.interfaces.IFileOutputStreamFactory;
import com.kaizen.scram.interfaces.IFileResource;

public class FileResource implements IFileResource {

	private final File file;
	private final FileOutputStream stream;

	public FileResource(File file, IFileOutputStreamFactory fos_factory) throws FileNotFoundException {
		this.file = file;
		this.file.getParentFile().mkdirs();
		this.stream = fos_factory.create(this.file);
	}

	@Override
	public File getFile() {
		return this.file;
	}

	@Override
	public FileOutputStream getStream() {
		return this.stream;
	}

}
