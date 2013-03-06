package com.kaizen.scram.interfaces;

import java.io.IOException;

public interface IFileWriterAdapter {

	void write(IFileResource file_resource, byte[] data) throws IOException;

}
