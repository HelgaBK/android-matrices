package com.tochanenko.karpyshyn.androidmatrices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner operators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Install adapter on spinner
        operators = findViewById(R.id.operators);
        String[] myResArray = getResources().getStringArray(R.array.operators);
        List<String> myResArrayList = Arrays.asList(myResArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, myResArrayList);
        operators.setAdapter(adapter);
    }
}
