package com.tochanenko.karpyshyn.androidmatrices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MatrixActivity extends AppCompatActivity {


    SingleMatrix currentMatrix = new SingleMatrix();
    double[] numbers = new double[25];

    //  Get all EditTexts
    EditText[][] matrix = new EditText[5][5];

    Button buttonCancel;
    Button buttonOK;
    Button buttonClear;

    SeekBar seekRows;
    SeekBar seekColumns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        final Bundle bundle = getIntent().getExtras();
        getValues(bundle);

        //  Get all EditTexts
        matrix[0][0] = findViewById(R.id.editText0_0);
        matrix[0][1] = findViewById(R.id.editText0_1);
        matrix[0][2] = findViewById(R.id.editText0_2);
        matrix[0][3] = findViewById(R.id.editText0_3);
        matrix[0][4] = findViewById(R.id.editText0_4);
        matrix[1][0] = findViewById(R.id.editText1_0);
        matrix[1][1] = findViewById(R.id.editText1_1);
        matrix[1][2] = findViewById(R.id.editText1_2);
        matrix[1][3] = findViewById(R.id.editText1_3);
        matrix[1][4] = findViewById(R.id.editText1_4);
        matrix[2][0] = findViewById(R.id.editText2_0);
        matrix[2][1] = findViewById(R.id.editText2_1);
        matrix[2][2] = findViewById(R.id.editText2_2);
        matrix[2][3] = findViewById(R.id.editText2_3);
        matrix[2][4] = findViewById(R.id.editText2_4);
        matrix[3][0] = findViewById(R.id.editText3_0);
        matrix[3][1] = findViewById(R.id.editText3_1);
        matrix[3][2] = findViewById(R.id.editText3_2);
        matrix[3][3] = findViewById(R.id.editText3_3);
        matrix[3][4] = findViewById(R.id.editText3_4);
        matrix[4][0] = findViewById(R.id.editText4_0);
        matrix[4][1] = findViewById(R.id.editText4_1);
        matrix[4][2] = findViewById(R.id.editText4_2);
        matrix[4][3] = findViewById(R.id.editText4_3);
        matrix[4][4] = findViewById(R.id.editText4_4);

        //  Get all buttons
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonClear = findViewById(R.id.buttonClear);
        buttonOK = findViewById(R.id.buttonOK);

        //  Get all seekBars
        seekColumns = findViewById(R.id.seekColumns);
        seekRows = findViewById(R.id.seekRows);

        update();

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putValuesBack();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValues(bundle);
                putValuesBack();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        currentMatrix.setValue(i, j, 0);
                currentMatrix.setColumns(5);
                currentMatrix.setRows(5);
                update();
            }
        });

        //  TODO :: on text changed

        seekRows.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Auto-generated method
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Auto-generated method
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentMatrix.setRows(seekRows.getProgress());
                update();
            }
        });
        seekColumns.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Auto-generated method
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Auto-generated method
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentMatrix.setColumns(seekRows.getProgress());
                update();
            }
        });
    }

    @Override
    public void onBackPressed() {
        putValuesBack();
    }

    private void putValuesBack() {
        Bundle b = new Bundle();
        Intent intent = new Intent();
        double[] doubleList = new double[25];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                doubleList[i * 5 + j] = currentMatrix.getValue(i, j);
        b.putDoubleArray("matrix", doubleList);
        intent.putExtras(b);
        intent.putExtra("columns", currentMatrix.getColumns());
        intent.putExtra("rows", currentMatrix.getRows());
        intent.putExtra("name", 1);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void getValues(Bundle bundle) {
        numbers = bundle.getDoubleArray("matrix");
        currentMatrix.setColumns(bundle.getInt("columns"));
        currentMatrix.setRows(bundle.getInt("rows"));
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                currentMatrix.setValue(i, j, numbers[i * 5 + j]);
    }

    private void update() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                matrix[i][j].setText(String.valueOf(currentMatrix.getValue(i, j)));
                matrix[i][j].setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
            }
        for (int i = currentMatrix.getColumns(); i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[i][j].setInputType(InputType.TYPE_NULL);
        for (int i = currentMatrix.getRows(); i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[j][i].setInputType(InputType.TYPE_NULL);
    }

}
