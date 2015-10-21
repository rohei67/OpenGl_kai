package and1107.and.opengl.test1;

import android.app.Activity;
import android.os.Bundle;

public class OpenGL0 extends Activity {
	MyGLView myGLView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//GlSurfaceViewを継承した独自のViewを画面に割り当てる
		myGLView = new MyGLView(this);
	    setContentView(myGLView);
	}
	 @Override
	  protected void onResume(){
	    super.onResume();
	    myGLView.onResume();		//描画処理の起動を行う（スレッドスタート）
	  }

	  @Override
	  protected void onPause(){
	    super.onPause();
	    myGLView.onPause();	//描画処理の停止を行う（スレッドストップ）
	  }


}
