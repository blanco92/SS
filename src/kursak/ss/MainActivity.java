package kursak.ss;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener {
 
	
	private static final int STOPSPLASH = 0;
	private static final long SPLASHTIME = 1800; //Время показа Splash картинки
	private ImageView splash;
	
	 Button btn1,btn2,btn3,btn4,btn5;
	 
	private Handler splashHandler = new Handler() { //создаем новый хэндлер
	 
	 @Override
	    public void handleMessage(Message msg) {
		      switch (msg.what) {
		      case STOPSPLASH:
		         //убираем Splash картинку - меняем видимость
		         splash.setVisibility(View.GONE);
		         break;
		         }
		      super.handleMessage(msg);
		     }
		};	

     @Override
     public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     btn1 = (Button) findViewById(R.id.button1);
	 btn2 = (Button) findViewById(R.id.button2);
	 btn3 = (Button) findViewById(R.id.button3);
	 btn4 = (Button) findViewById(R.id.button4);
	 btn5 = (Button) findViewById(R.id.button5);
	    
	 btn1.setOnClickListener(this);
	 btn2.setOnClickListener(this);
	 btn3.setOnClickListener(this);
	 btn4.setOnClickListener(this);
	 btn5.setOnClickListener(this);
	 
	 splash = (ImageView) findViewById(R.id.splashscreen);  //получаем индентификатор ImageView с Splash картинкой
     Message msg = new Message();
     msg.what = STOPSPLASH;
     splashHandler.sendMessageDelayed(msg, SPLASHTIME);
     }

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1:
			Intent i1 = new Intent(this, kursak.ss.DecActivity.class);
			this.startActivity(i1);	
			break;
		case R.id.button2:
			Intent i2 = new Intent(this, kursak.ss.BinActivity.class);
			this.startActivity(i2);	
			break;
		case R.id.button3:
			Intent i3 = new Intent(this, kursak.ss.OctActivity.class);
			this.startActivity(i3);	
			break;
		case R.id.button4:
			Toast.makeText(this, "На обновлении", Toast.LENGTH_LONG).show();
			break;
		case R.id.button5:
			Intent i5 = new Intent(this, kursak.ss.Deystvia.class);
			this.startActivity(i5);	
			break;
		}
	}

}