package com.kaizen.scram.interfaces;

import java.io.File;
import java.io.FileOutputStream;

public interface IFileResource {

	File getFile();

	FileOutputStream getStream();

}
