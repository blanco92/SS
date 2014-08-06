package kursak.ss;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Deystvia extends Activity implements OnClickListener {

	  EditText etNum1,etNum2;
	  Button btnAdd,btnSub,btnDel,btnUm;
	  TextView tvResult,tvResult2,tvResult3;
	  int num1 = 0,num2 = 0;
	  int as,bs,summa;
	  RadioGroup  radiogroup1,radiogroup2;
	  RadioButton rb_0,rb_1,rb_2,rb_00,rb_01,rb_02;
	  String result,result2;
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.deys);

	    // находим элементы
	    etNum1 = (EditText) findViewById(R.id.etNum1);
	    etNum2 = (EditText) findViewById(R.id.etNum2);
	    btnAdd = (Button) findViewById(R.id.btnAdd);
	    btnSub = (Button) findViewById(R.id.btnSub);
	    btnUm = (Button) findViewById(R.id.btnUm);
	    btnDel = (Button) findViewById(R.id.btnDel);
	    tvResult = (TextView) findViewById(R.id.tvResult);
	    tvResult2 = (TextView) findViewById(R.id.tvResult2);
	    tvResult3 = (TextView) findViewById(R.id.tvResult3);
	    radiogroup1 = (RadioGroup )findViewById(R.id.radioGroup1);
	    radiogroup2 = (RadioGroup )findViewById(R.id.radioGroup2);
	    rb_0 = (RadioButton)findViewById(R.id.radio0);
	    rb_1 = (RadioButton)findViewById(R.id.radio1);
	    rb_2 = (RadioButton)findViewById(R.id.radio2);
	    rb_00 = (RadioButton)findViewById(R.id.radio00);
	    rb_01 = (RadioButton)findViewById(R.id.radio01);
	    rb_02 = (RadioButton)findViewById(R.id.radio02);
	    
	    // прописываем обработчик
	    btnAdd.setOnClickListener(this);
	    btnSub.setOnClickListener(this);
	    btnUm.setOnClickListener(this);
	    btnDel.setOnClickListener(this);
	    rb_0.setOnClickListener(this);
	    rb_1.setOnClickListener(this);
	    rb_2.setOnClickListener(this);
	    rb_00.setOnClickListener(this);
	    rb_01.setOnClickListener(this);
	    rb_02.setOnClickListener(this);
	  }

	  public void DecToOct(){
	  result = "";
	  int value8 = summa;
		 
		while ( value8  >= 1 ) {
			int p = value8 / 8;
			int q = value8 % 8;
			
			result = q + result;
			value8 = p;
		}
       }
	  
	  public void DecToBin(){
		result2 = "";
		int value2 = summa;
		 
		while ( value2 >= 1 ) {
			int p = value2 / 2;
			int q = value2 % 2;
			
			result2 = q + result2;
			value2 = p;
		}
	  }

	  public void onClick(View v) { 
		  if (TextUtils.isEmpty(etNum1.getText().toString())) {
		      return;
		    }
		   if (Integer.parseInt(etNum1.getText().toString()) == 0) {
		    	 tvResult.setText("Результат " + "0");
			 } 
		   
		   num1 = Integer.parseInt(etNum1.getText().toString()); 
		   num2 = Integer.parseInt(etNum2.getText().toString());
		   
		 switch (v.getId()) {
		 case R.id.radio0:
			      as = 0;
				  int value1 = 0;
				  value1 = num1;		
					
					int length1 = (int)Math.log10( value1 );
					
					for (int i = 0; i <= length1; i++) {
					
						int a = value1 % 10;
						value1 /= 10;
						
						as += a * (int)Math.pow( 2.0, (double)i );
					}
		    	break;
		    	
		 case R.id.radio00:
			  bs = 0;
			  int value2 = 0;
			  value2 = num2;		
				
				int length2 = (int)Math.log10( value2 );
				
				for (int i = 0; i <= length2; i++) {
				
					int a = value2 % 10;
					value2 /= 10;
					
					bs += a * (int)Math.pow( 2.0, (double)i );
				}
	    	break;
	    	
		 case R.id.radio1:
			  as = 0;
			  int value = 0;
			  value = num1;		
				
				int length = (int)Math.log10( value );
				
				for (int i = 0; i <= length; i++) {
				
					int a = value % 10;
					value /= 10;
					
					as += a * (int)Math.pow( 8.0, (double)i );
				}
	    	break;
	    	
		 case R.id.radio01:
			  bs = 0;
			  int value21 = 0;
			  value = num2;		
				
				int length21 = (int)Math.log10( value );
				
				for (int i = 0; i <= length21; i++) {
				
					int a = value % 10;
					value /= 10;
					
					bs += a * (int)Math.pow( 8.0, (double)i );
				}
	    	break;
	    	
		 case R.id.radio2:
			    as = 0;
				as = num1;
				
	    	break;
	    	
		 case R.id.radio02:
			    bs = 0;
				bs = num2;
				
	    	break;
	    	
	    case R.id.btnAdd: 
	    	summa = 0;
	    	summa = as + bs;
	    	tvResult.setText("В 10:"+ as +"+" + bs + "=" + summa); 
	    	DecToOct();
	    	tvResult2.setText("В 8:" + result);
	    	DecToBin();
	    	tvResult3.setText("В 2:" + result2);
	    	break;
	    	
	    case R.id.btnSub:
	    	summa = 0;
	    	summa = as - bs;
	    	tvResult.setText("В 10:"+ as +"-" + bs + "=" + summa); 
	    	DecToOct();
	    	tvResult2.setText("В 8:" + result);
	    	DecToBin();
	    	tvResult3.setText("В 2:" + result2);
	    	break;
	    case R.id.btnUm:
	    	summa = 0;
	    	summa = as * bs;
	    	tvResult.setText("В 10:"+ as +"*" + bs + "=" + summa); 
	    	DecToOct();
	    	tvResult2.setText("В 8:" + result);
	    	DecToBin();
	    	tvResult3.setText("В 2:" + result2);
	    	break;
	    case R.id.btnDel:
	    	summa = 0;
	    	summa = as / bs;
	    	tvResult.setText("В 10:"+ as +"/" + bs + "=" + summa);
	    	DecToOct();
	    	tvResult2.setText("В 8:" + result);
	    	DecToBin();
	    	tvResult3.setText("В 2:" + result2);
	    	break;
	    }	

	  }
}