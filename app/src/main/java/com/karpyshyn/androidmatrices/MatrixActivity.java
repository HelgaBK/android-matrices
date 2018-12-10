package com.karpyshyn.androidmatrices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

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

    int type;

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
                currentMatrix.setRows(seekRows.getProgress() + 1);
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
                currentMatrix.setColumns(seekColumns.getProgress() + 1);
                update();
            }
        });

        //  Set all TextChangedListeners
        matrix[0][0].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[0][0].getText().toString().equals(""))
                            currentMatrix.setValue(0, 0, 0);
                        else
                            currentMatrix.setValue(
                                0, 0, Double.parseDouble(matrix[0][0].getText().toString()));
                    }
                });
        matrix[0][1].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[0][1].getText().toString().equals(""))
                            currentMatrix.setValue(0, 1, 0);
                        else
                            currentMatrix.setValue(
                                0, 1, Double.parseDouble(matrix[0][1].getText().toString()));
                    }
                });
        matrix[0][2].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[0][2].getText().toString().equals(""))
                            currentMatrix.setValue(0, 2, 0);
                        else
                            currentMatrix.setValue(
                                0, 2, Double.parseDouble(matrix[0][2].getText().toString()));
                    }
                });
        matrix[0][3].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[0][3].getText().toString().equals(""))
                            currentMatrix.setValue(0, 3, 0);
                        else
                            currentMatrix.setValue(
                                0, 3, Double.parseDouble(matrix[0][3].getText().toString()));
                    }
                });
        matrix[0][4].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[0][4].getText().toString().equals(""))
                            currentMatrix.setValue(0, 4, 0);
                        else
                            currentMatrix.setValue(
                                0, 4, Double.parseDouble(matrix[0][4].getText().toString()));
                    }
                });
        matrix[1][0].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[1][0].getText().toString().equals(""))
                            currentMatrix.setValue(1, 0, 0);
                        else
                            currentMatrix.setValue(
                                1, 0, Double.parseDouble(matrix[1][0].getText().toString()));
                    }
                });
        matrix[1][1].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[1][1].getText().toString().equals(""))
                            currentMatrix.setValue(1, 1, 0);
                        else
                            currentMatrix.setValue(
                                1, 1, Double.parseDouble(matrix[1][1].getText().toString()));
                    }
                });
        matrix[1][2].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[1][2].getText().toString().equals(""))
                            currentMatrix.setValue(1, 2, 0);
                        else
                            currentMatrix.setValue(
                                1, 2, Double.parseDouble(matrix[1][2].getText().toString()));
                    }
                });
        matrix[1][3].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[1][3].getText().toString().equals(""))
                            currentMatrix.setValue(1, 3, 0);
                        else
                            currentMatrix.setValue(
                                1, 3, Double.parseDouble(matrix[1][3].getText().toString()));
                    }
                });
        matrix[1][4].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[1][4].getText().toString().equals(""))
                            currentMatrix.setValue(1, 4, 0);
                        else
                            currentMatrix.setValue(
                                1, 4, Double.parseDouble(matrix[1][4].getText().toString()));
                    }
                });
        matrix[2][0].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[2][0].getText().toString().equals(""))
                            currentMatrix.setValue(2, 0, 0);
                        else
                            currentMatrix.setValue(
                                2, 0, Double.parseDouble(matrix[2][0].getText().toString()));
                    }
                });
        matrix[2][1].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[2][1].getText().toString().equals(""))
                            currentMatrix.setValue(2, 1, 0);
                        else
                            currentMatrix.setValue(
                                2, 1, Double.parseDouble(matrix[2][1].getText().toString()));
                    }
                });
        matrix[2][2].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[2][2].getText().toString().equals(""))
                            currentMatrix.setValue(2, 2, 0);
                        else
                            currentMatrix.setValue(
                                2, 2, Double.parseDouble(matrix[2][2].getText().toString()));
                    }
                });
        matrix[2][3].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[2][3].getText().toString().equals(""))
                            currentMatrix.setValue(2, 3, 0);
                        else
                            currentMatrix.setValue(
                                2, 3, Double.parseDouble(matrix[2][3].getText().toString()));
                    }
                });
        matrix[2][4].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[2][4].getText().toString().equals(""))
                            currentMatrix.setValue(2, 4, 0);
                        else
                            currentMatrix.setValue(
                                2, 4, Double.parseDouble(matrix[2][4].getText().toString()));
                    }
                });
        matrix[3][0].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[3][0].getText().toString().equals(""))
                            currentMatrix.setValue(3, 0, 0);
                        else
                            currentMatrix.setValue(
                                3, 0, Double.parseDouble(matrix[3][0].getText().toString()));
                    }
                });
        matrix[3][1].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[3][1].getText().toString().equals(""))
                            currentMatrix.setValue(3, 1, 0);
                        else
                            currentMatrix.setValue(
                                3, 1, Double.parseDouble(matrix[3][1].getText().toString()));
                    }
                });
        matrix[3][2].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[3][2].getText().toString().equals(""))
                            currentMatrix.setValue(3, 2, 0);
                        else
                            currentMatrix.setValue(
                                3, 2, Double.parseDouble(matrix[3][2].getText().toString()));
                    }
                });
        matrix[3][3].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[3][3].getText().toString().equals(""))
                            currentMatrix.setValue(3, 3, 0);
                        else
                            currentMatrix.setValue(
                                3, 3, Double.parseDouble(matrix[3][3].getText().toString()));
                    }
                });
        matrix[3][4].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[3][4].getText().toString().equals(""))
                            currentMatrix.setValue(3, 4, 0);
                        else
                            currentMatrix.setValue(
                                3, 4, Double.parseDouble(matrix[3][4].getText().toString()));
                    }
                });
        matrix[4][0].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[4][0].getText().toString().equals(""))
                            currentMatrix.setValue(4, 0, 0);
                        else
                            currentMatrix.setValue(
                                4, 0, Double.parseDouble(matrix[4][0].getText().toString()));
                    }
                });
        matrix[4][1].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[4][1].getText().toString().equals(""))
                            currentMatrix.setValue(4, 1, 0);
                        else
                            currentMatrix.setValue(
                                4, 1, Double.parseDouble(matrix[4][1].getText().toString()));
                    }
                });
        matrix[4][2].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[4][2].getText().toString().equals(""))
                            currentMatrix.setValue(4, 2, 0);
                        else
                            currentMatrix.setValue(
                                4, 2, Double.parseDouble(matrix[4][2].getText().toString()));
                    }
                });
        matrix[4][3].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[4][3].getText().toString().equals(""))
                            currentMatrix.setValue(4, 3, 0);
                        else
                            currentMatrix.setValue(
                                4, 3, Double.parseDouble(matrix[4][3].getText().toString()));
                    }
                });
        matrix[4][4].addTextChangedListener(new TextWatcher()  {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)  {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft )  {
                        // Auto-generated method
                    }

                    @Override
                    public void afterTextChanged(Editable s)  {
                        // Auto-generated method
                        if (matrix[4][4].getText().toString().equals(""))
                            currentMatrix.setValue(4, 4, 0);
                        else
                            currentMatrix.setValue(
                                4, 4, Double.parseDouble(matrix[4][4].getText().toString()));
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
        intent.putExtra("name", type);
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
        type = bundle.getInt("name");
    }

    private void update() {
        seekColumns.setProgress(currentMatrix.getColumns() - 1);
        seekRows.setProgress(currentMatrix.getRows() - 1);
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                matrix[i][j].setText(String.valueOf(currentMatrix.getValue(i, j)));
                if (matrix[i][j].getInputType() != InputType.TYPE_NUMBER_FLAG_DECIMAL) {
                    //matrix[i][j].setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    matrix[i][j].setTextColor(getResources().getColor(R.color.darkTextColor));
                }
            }
        for (int i = currentMatrix.getColumns(); i < 5; i++)
            for (int j = 0; j < 5; j++) {
                //matrix[j][i].setInputType(InputType.TYPE_NULL);
                matrix[j][i].setTextColor(getResources().getColor(R.color.colorAccent));
            }
        for (int i = 0; i < 5; i++)
            for (int j = currentMatrix.getRows(); j < 5; j++) {
               // matrix[i][j].setInputType(InputType.TYPE_NULL);
                matrix[j][i].setTextColor(getResources().getColor(R.color.colorAccent));
            }
    }

}
