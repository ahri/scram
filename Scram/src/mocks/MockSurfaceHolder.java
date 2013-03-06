package mocks;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;

public class MockSurfaceHolder implements SurfaceHolder {

	@Override
	public void addCallback(Callback callback) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "addCallback(Callback callback) called");
	}

	@Override
	public Surface getSurface() {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "getSurface() called, returning null");
		return null;//new Surface(new SurfaceTexture(0));
	}

	@Override
	public Rect getSurfaceFrame() {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "getSurfaceFrame() called, returning null");
		return null;
	}

	@Override
	public boolean isCreating() {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "isCreating() called, returning false");
		return false;
	}

	@Override
	public Canvas lockCanvas() {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "lockCanvas() called, returning null");
		return null;
	}

	@Override
	public Canvas lockCanvas(Rect dirty) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "lockCanvas(Rect dirty) called, returning null");
		return null;
	}

	@Override
	public void removeCallback(Callback callback) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "removeCallback(Callback callback) called");
	}

	@Override
	public void setFixedSize(int width, int height) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "setFixedSize(int width, int height)");		
	}

	@Override
	public void setFormat(int format) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "setFormat(int format) called");
	}

	@Override
	public void setKeepScreenOn(boolean screenOn) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "setKeepScreenOn(boolean screenOn) called");
	}

	@Override
	public void setSizeFromLayout() {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "setSizeFromLayout() called");
	}

	@Override
	public void setType(int type) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "setType(int type) called");
	}

	@Override
	public void unlockCanvasAndPost(Canvas canvas) {
		// TODO Auto-generated method stub
		Log.i(this.getClass().getSimpleName(), "unlockCanvasAndPost(Canvas canvas) called");
	}

}
