package com.kaizen.scram.interfaces;

import java.io.File;
import java.io.FileNotFoundException;


public interface IFileResourceFactory {

	public IFileResource create(File file) throws FileNotFoundException;

}