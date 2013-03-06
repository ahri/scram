package com.kaizen.scram.factories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.kaizen.scram.interfaces.IFileOutputStreamFactory;

public class FileOutputStreamFactory implements IFileOutputStreamFactory {

	@Override
	public FileOutputStream create(File file) throws FileNotFoundException {
		return new FileOutputStream(file);
	}
	
}
