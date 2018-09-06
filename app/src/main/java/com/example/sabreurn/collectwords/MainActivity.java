package com.example.sabreurn.collectwords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText inputFieldEditText;
    Button addToListButton;
    Button clearListButton;
    Button printListButton;
    TextView listContentsTextView;
    List<String> inputList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFieldEditText = findViewById(R.id.inputFieldEditText);
        addToListButton = findViewById(R.id.addToListButton);
        clearListButton = findViewById(R.id.clearListButton);
        printListButton = findViewById(R.id.printListButton);
        listContentsTextView = findViewById(R.id.listContentsTextView);
        inputList = new ArrayList<>();

        addToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputList.add(inputFieldEditText.getText().toString());
            }
        });

        clearListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputList.clear();
            }
        });

        printListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = "";
                for(String s : inputList) {
                    contents += s + "\t";
                }
                listContentsTextView.setText(contents);
            }
        });
    }
}
