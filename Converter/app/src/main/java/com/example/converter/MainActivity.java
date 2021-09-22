package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

/*
    public void convert(View view) {
        EditText DollerField = (EditText) findViewById(R.id.DollerField);
        Double DollerAmount = Double.parseDouble(DollerField.getText().toString());
        Double EgpAmount = DollerAmount * 15;
        Toast.makeText(getApplicationContext(), EgpAmount.toString() + "Egp", Toast.LENGTH_LONG).show();
    }

*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}