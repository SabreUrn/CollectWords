package com.example.sabreurn.collectwords;

import android.content.Intent;
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

	public static final String RESULT = "result";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		firstNumberEditText = findViewById(R.id.firstNumberEditText);
		secondNumberEditText = findViewById(R.id.secondNumberEditText);
		calcButton = findViewById(R.id.calcButton);

		calcButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double firstNum = Double.parseDouble(firstNumberEditText.getText().toString());
				double secondNum = Double.parseDouble(secondNumberEditText.getText().toString());
				double result = firstNum + secondNum;

				Intent data = new Intent();
				data.putExtra(RESULT, result);
				setResult(RESULT_OK, data);
				finish();
			}
		});
	}

}
