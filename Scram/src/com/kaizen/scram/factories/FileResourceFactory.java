package com.kaizen.scram.factories;

import java.io.File;
import java.io.FileNotFoundException;

import com.kaizen.scram.concretes.FileResource;
import com.kaizen.scram.interfaces.IFileOutputStreamFactory;
import com.kaizen.scram.interfaces.IFileResource;
import com.kaizen.scram.interfaces.IFileResourceFactory;

public class FileResourceFactory implements IFileResourceFactory {

	private final IFileOutputStreamFactory fos_factory;

	public FileResourceFactory(IFileOutputStreamFactory fos_factory) {
		this.fos_factory = fos_factory;
	}
	
	@Override
	public IFileResource create(File file) throws FileNotFoundException {
		return new FileResource(file, this.fos_factory);
	}
	
}
