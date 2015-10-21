package and1107.and.opengl.test1;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MyGLView extends GLSurfaceView {
	MyRenderer _myRenderer;
	public static boolean _isRotate = false;

	public MyGLView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ

		_myRenderer = new MyRenderer();
		setRenderer(_myRenderer);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() != MotionEvent.ACTION_DOWN)
			return false;
		_isRotate = !_isRotate;
		if (_isRotate)
			_myRenderer.setMovable();
		else
			_myRenderer.setUnMovable();
		return true;
	}
}


