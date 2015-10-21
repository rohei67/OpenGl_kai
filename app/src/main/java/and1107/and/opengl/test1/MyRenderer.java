package and1107.and.opengl.test1;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyRenderer implements Renderer {
	private MyCube _cube = new MyCube();
	private float _degree = 0.0f;
	private float _zPosition = -3f;

	private boolean _isZooming;
	private boolean _movable;

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glEnable(GL10.GL_LIGHTING);
		gl.glEnable(GL10.GL_LIGHT0);
		GLU.gluPerspective(gl, 45f, (float) width / height, 1f, 50f);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glTranslatef(0, 0, _zPosition);
		gl.glRotatef(_degree, 1, 0, 0);
		gl.glRotatef(_degree, 0, 1, 0);

		_cube.draw(gl);

		if (!_movable) return;
		move();
	}

	private void move() {
		if (_isZooming)
			zoomIn();
		else
			zoomOut();
	}

	private void zoomOut() {
		if (_degree-- > 0.0f)
			_zPosition -= 0.02f;
		else
			_isZooming = true;
	}

	private void zoomIn() {
		if (_degree++ < 90.0f)
			_zPosition += 0.02f;
		else
			_isZooming = false;
	}

	public void setMovable() {
		_movable = true;
	}

	public void setUnMovable() {
		_movable = false;
	}
}
