package com.kaizen.scram.test;

import static org.junit.Assert.*;

import org.junit.Test;


import com.kaizen.scram.concretes.*;
import com.kaizen.scram.interfaces.*;

public class TestPhoto {

	@Test
	public void save_filename_fileSystemWrite() {
		IPhoto photo = new Photo();
		photo.save("foo");
		fail("haven't really done anything yet");
		// TODO: mock out the filesystem and ensure the FS write is called: con't care about the FS itself
	}

}
