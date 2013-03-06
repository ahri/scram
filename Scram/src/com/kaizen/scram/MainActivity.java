package com.kaizen.scram;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.TextureView.SurfaceTextureListener;

import com.kaizen.scram.concretes.CameraAdapter;
import com.kaizen.scram.concretes.DcimPathProvider;
import com.kaizen.scram.concretes.ExternalFileWriterAdapter;
import com.kaizen.scram.factories.CameraCallbackFactory;
import com.kaizen.scram.factories.FileOutputStreamFactory;
import com.kaizen.scram.factories.FileResourceFactory;
import com.kaizen.scram.factories.ReactionFactory;
import com.kaizen.scram.interfaces.ICameraAdapter;
import com.kaizen.scram.interfaces.ICameraCallbackFactory;
import com.kaizen.scram.interfaces.IFileOutputStreamFactory;
import com.kaizen.scram.interfaces.IFileResourceFactory;
import com.kaizen.scram.interfaces.IFileWriterAdapter;
import com.kaizen.scram.interfaces.IPathProvider;
import com.kaizen.scram.interfaces.IReactionFactory;

public class MainActivity extends Activity implements SurfaceTextureListener {

    private IReactionFactory reaction_factory;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //SurfaceHolder surface = new MockSurfaceHolder();
        SurfaceTexture texture = new SurfaceTexture(0);
        IFileOutputStreamFactory fos_factory = new FileOutputStreamFactory();
        IFileResourceFactory resource_factory = new FileResourceFactory(fos_factory);
        IFileWriterAdapter writer = new ExternalFileWriterAdapter();
        ICameraCallbackFactory callback_factory = new CameraCallbackFactory(writer);
        ICameraAdapter camera = new CameraAdapter(texture, callback_factory);
        IPathProvider path_provider = new DcimPathProvider(this, resource_factory);
        
        this.reaction_factory = new ReactionFactory(camera, path_provider);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
    	Log.i("Event", "Event: a=" + event.getAction() + ", keycode=" + event.getKeyCode());
        return this.reaction_factory.handle(event);
    }


	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture arg0, int arg1,
			int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture arg0, int arg1,
			int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
