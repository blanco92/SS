package kursak.ss;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BinActivity extends Activity implements OnClickListener {

	  EditText etNum1;
	  Button btnDec,btnOct,btnHex;
	  TextView tvResult;
	  int result;
	  int num1;
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.binl);

	    etNum1 = (EditText) findViewById(R.id.etNum1);
	    btnDec = (Button) findViewById(R.id.BbtnDec);
	    btnOct = (Button) findViewById(R.id.BbtnOct);
	    btnHex = (Button) findViewById(R.id.BbtnHex);
	    tvResult = (TextView) findViewById(R.id.tvResult);
	    
	    btnDec.setOnClickListener(this);
	    btnOct.setOnClickListener(this);
	    btnHex.setOnClickListener(this);
	  }
	  
	  public void Bin(){
		    num1 = 0;
  		
		    if (TextUtils.isEmpty(etNum1.getText().toString())) {
		      return;
		    }
		    
		    if (Integer.parseInt(etNum1.getText().toString()) == 0) {
		    	 tvResult.setText("Результат " + "0");
			    } 
	         
		    num1 = Integer.parseInt(etNum1.getText().toString()); 

		  result = 0;
		  int value = num1;		
			
			int length = (int)Math.log10( value );
			
			for (int i = 0; i <= length; i++) {
			
				int a = value % 10;
				value /= 10;
				
				result += a * (int)Math.pow( 2.0, (double)i );
			}  
			
	  }
	  
	  public void onClick(View v) {
		        
	    switch (v.getId()) {
	    case R.id.BbtnDec:
         Bin();	
         tvResult.setText("Результат " + result);
     	break;
			
	    case R.id.BbtnOct:
	    	Bin();
	    	
	    	int value8 = result;
			String result8 = "";
			
			while ( value8 >= 1 ) {
				int p = value8 / 8;
				int q = value8 % 8;
				
				result8 = q + result8;
				value8 = p;
			}
			tvResult.setText("Результат " + result8);
	    	break;
	    	
	    case R.id.BbtnHex:
            Bin();

	    	int value16 = result;
			String n = "";
			String result16 = "";
			
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
				
				result16 = n + result16;
				value16 = p;
			}
			tvResult.setText("Результат " + result16);
	    	break;	
	    }

	    
	  }

}