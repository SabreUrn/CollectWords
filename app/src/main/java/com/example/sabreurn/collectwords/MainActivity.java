package com.example.sabreurn.collectwords;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	EditText inputFieldEditText;
	TextView listContentsTextView;
	List<String> inputList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inputFieldEditText = findViewById(R.id.inputFieldEditText);
		listContentsTextView = findViewById(R.id.listContentsTextView);
		inputList = new ArrayList<>();

		//show keyboard automatically
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		//imm.showSoftInput(inputFieldEditText, InputMethodManager.SHOW_IMPLICIT);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK) {
			double result = data.getDoubleExtra(SecondActivity.RESULT, 0);
			addToList(Double.toString(result));
		}
	}

	public void addToList(String entry) {
		inputList.add(entry);
		inputFieldEditText.getText().clear();
	}


	public void viewAddToList(View view) {
		addToList(inputFieldEditText.getText().toString());
	}

	public void viewClearList(View view) {
		inputList.clear();
	}

	public void viewPrintList(View view) {
		String contents = TextUtils.join(", ", inputList);
		listContentsTextView.setText(contents);
	}

	public void goSecondActivity(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		startActivityForResult(intent, 666);
	}
}
