package com.kaizen.scram.test;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import android.view.KeyEvent;

import com.kaizen.scram.factories.ReactionFactory;
import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.IPathProvider;
import com.kaizen.scram.interfaces.IReactionFactory;

// http://developer.android.com/reference/android/hardware/Camera.html

@RunWith(PowerMockRunner.class)
@PrepareForTest({KeyEvent.class})
public class TestReactionFactory {

	@Test
	public void handle_KeyEventActionDownKeycodeVolUp_true() {
		// Arrange
		KeyEvent event = mock(KeyEvent.class);
		when(event.getAction()).thenReturn(KeyEvent.ACTION_DOWN);
		when(event.getKeyCode()).thenReturn(KeyEvent.KEYCODE_VOLUME_UP);
		
		ICameraAdapter camera = mock(ICameraAdapter.class);
		IPathProvider path_provider = mock(IPathProvider.class);
		IReactionFactory rf = new ReactionFactory(camera, path_provider);
		
		// Act
		boolean run = rf.handle(event);
		
		// Assert
		assertTrue(run);
	}

}
