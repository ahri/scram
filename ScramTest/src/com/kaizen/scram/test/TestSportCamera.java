package com.kaizen.scram.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.kaizen.scram.concretes.*;
import com.kaizen.scram.interfaces.*;

public class TestSportCamera {

	@Test
	public void takePhoto_TakePhoto_TakePhoto() {
		ICameraAdapter cam_adapter = mock(ICameraAdapter.class);
		ISportCamera sport_camera = new SportCamera(cam_adapter);
		
		IPhoto photo = sport_camera.takePhoto();
		
		fail("no assertions yet...");
	}

}
