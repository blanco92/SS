package kursak.ss;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecActivity extends Activity implements OnClickListener {

	  EditText etNum1;
	  Button btnBin,btnOct,btnHex;
	  TextView tvResult;
	  String result = "";
    
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.decl);

	    // находим элементы
	    etNum1 = (EditText) findViewById(R.id.etNum1);
	    btnBin = (Button) findViewById(R.id.btnBin);
	    btnOct = (Button) findViewById(R.id.btnOct);
	    btnHex = (Button) findViewById(R.id.btnHex);
	    tvResult = (TextView) findViewById(R.id.tvResult);
	    
	    // прописываем обработчик
	    btnBin.setOnClickListener(this);
	    btnOct.setOnClickListener(this);
	    btnHex.setOnClickListener(this);
	  }
	  

 	  public void onClick(View v) { 
		  String result = "";
		    int num1 = 0;
		    
		    // Проверяем поля на пустоту
		    if (TextUtils.isEmpty(etNum1.getText().toString())) {
		      return;
		    }
		    if (Integer.parseInt(etNum1.getText().toString()) == 0) {
		    	 tvResult.setText("Результат " + "0");
			    } 
		    
		    // читаем EditText и заполняем переменные числами
		    num1 = Integer.parseInt(etNum1.getText().toString());
		    
	    // определяем нажатую кнопку и выполняем соответствующую операцию
	    // в oper пишем операцию, потом будем использовать в выводе
	    switch (v.getId()) {
	    case R.id.btnBin:
		    
				int value2 = num1;
				 
				while ( value2 >= 1 ) {
					int p = value2 / 2;
					int q = value2 % 2;
					
					result = q + result;
					value2 = p;
				}
			break;
			
	    case R.id.btnOct:
	    	   int value8 = num1;
				 
				while ( value8  >= 1 ) {
					int p = value8 / 8;
					int q = value8 % 8;
					
					result = q + result;
					value8 = p;
				}
	    	break;
	    	
	    case R.id.btnHex:
		    
		    int value16 = num1;
			String n = "";
			
			while ( value16  >= 1 ) {	
				int p = value16 / 16;
				int q = value16 % 16;
				
				switch(q){
				case 0:
					n = "0";
					break;
				case 1:
					n = "1";
					break;
				case 2:
					n = "2";
					break;
				case 3:
					n = "3";
					break;
				case 4:
					n = "4";
					break;
				case 5:
					n = "5";
					break;
				case 6:
					n = "6";
					break;
				case 7:
					n = "7";
					break;
				case 8:
					n = "8";
					break;
				case 9:
					n = "9";
					break;
				case 10:
				    n = "A";
				    break;
				case 11:
				    n = "B";
				    break;
				case 12:
				    n = "C";
				    break;
				case 13:
				    n = "D";
				    break;
				case 14:
				    n = "E";
				    break;
				case 15:
				    n = "F";
				    break;
				}
				
				result = n + result;
				value16 = p;
			}
	    	break;	
	    }	
	    tvResult.setText("Результат " + result);
	  }
}
