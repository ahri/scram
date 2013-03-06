package com.kaizen.scram.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public interface IFileOutputStreamFactory {

	public FileOutputStream create(File file) throws FileNotFoundException;

}