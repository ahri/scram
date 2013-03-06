package com.kaizen.scram.factories;

import java.io.FileNotFoundException;

import android.util.Log;
import android.view.KeyEvent;

import com.kaizen.scram.concretes.TakePhoto;
import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.IPathProvider;
import com.kaizen.scram.interfaces.IReactionFactory;

public class ReactionFactory implements IReactionFactory {
	
	private final ICameraAdapter camera;
	private final IPathProvider path_provider;

	public ReactionFactory(ICameraAdapter camera, IPathProvider path_provider) {
		this.camera = camera;
		this.path_provider = path_provider;
	}

	@Override
	public boolean handle(KeyEvent event) {
		try {
			(new TakePhoto(this.camera, this.path_provider.resource("foo.jpg"))).run();
		} catch (FileNotFoundException e) {
			// TODO: handle?
			Log.e(this.getClass().getName(), e.getMessage());
		}
		return true;
	}

}
