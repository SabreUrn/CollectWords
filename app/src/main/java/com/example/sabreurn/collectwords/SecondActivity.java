package com.example.sabreurn.collectwords;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

	EditText firstNumberEditText;
	EditText secondNumberEditText;
	Button calcButton;
	EditText resultEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		firstNumberEditText = findViewById(R.id.firstNumberEditText);
		secondNumberEditText = findViewById(R.id.secondNumberEditText);
		calcButton = findViewById(R.id.calcButton);
		resultEditText = findViewById(R.id.resultEditText);
		resultEditText.setInputType(InputType.TYPE_NULL);

		calcButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int firstNum = Integer.parseInt(firstNumberEditText.getText().toString());
				int secondNum = Integer.parseInt(secondNumberEditText.getText().toString());
				int result = firstNum + secondNum;
				resultEditText.setInputType(InputType.TYPE_CLASS_TEXT);
				resultEditText.setText(Integer.toString(result));
				resultEditText.setInputType(InputType.TYPE_NULL);
			}
		});
	}

}
