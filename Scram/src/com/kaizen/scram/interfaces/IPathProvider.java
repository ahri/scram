package com.kaizen.scram.interfaces;

import java.io.FileNotFoundException;


public interface IPathProvider {

	IFileResource resource(String filename) throws FileNotFoundException;

}
