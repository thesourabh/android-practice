package com.example.projectone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Project1Activity extends Activity {
      @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setTitle("Calculator");
	    setContentView(R.layout.main);
	    Button add = (Button) findViewById(R.id.add);
	    Button sub = (Button) findViewById(R.id.sub);
	    Button mul = (Button) findViewById(R.id.mul);
	    Button div = (Button) findViewById(R.id.div);
	    add.setOnClickListener(listener);
	    sub.setOnClickListener(listener);
	    mul.setOnClickListener(listener);
	    div.setOnClickListener(listener);
	  }
	  private Button.OnClickListener listener = new Button.OnClickListener() {
	    public void onClick(View v) {
	        EditText text1 = (EditText) findViewById(R.id.text1);
	        EditText text2 = (EditText) findViewById(R.id.text2);
		      int x = Integer.parseInt(text1.getText().toString());
		      int y = Integer.parseInt(text2.getText().toString());
		      int ans=0;
		      String fin;
		      switch(v.getId()){
		      case R.id.add:
		      ans=x+y;
		      break;
		      case R.id.sub:
		      ans=x-y;
		      break;
		      case R.id.mul:
		      ans=x*y;
		      break;
		      case R.id.div:
		      ans=x/y;
		      break;
		      }
		      fin=String.valueOf(ans);
		      Toast.makeText(getApplicationContext(), fin, Toast.LENGTH_SHORT).show();
	    }
	  };
	}
