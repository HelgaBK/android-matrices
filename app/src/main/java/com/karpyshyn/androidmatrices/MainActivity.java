package com.karpyshyn.androidmatrices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //  Data classes of each Matrix
    SingleMatrix dataA = new SingleMatrix();
    SingleMatrix dataB = new SingleMatrix();
    SingleMatrix res = new SingleMatrix();

    //  Spinner of operators
    Spinner operators;

    //  A and B matrices
    TextView matrixA;
    TextView matrixB;

    //  A res matrix
    TextView[][] matrix = new TextView[5][5];

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

        //  Get matrices views
        matrixA = findViewById(R.id.matrixA);
        matrixB = findViewById(R.id.matrixB);

        //  Get result matrix view
        matrix[0][0] = findViewById(R.id.textView0_0);
        matrix[0][1] = findViewById(R.id.textView0_1);
        matrix[0][2] = findViewById(R.id.textView0_2);
        matrix[0][3] = findViewById(R.id.textView0_3);
        matrix[0][4] = findViewById(R.id.textView0_4);
        matrix[1][0] = findViewById(R.id.textView1_0);
        matrix[1][1] = findViewById(R.id.textView1_1);
        matrix[1][2] = findViewById(R.id.textView1_2);
        matrix[1][3] = findViewById(R.id.textView1_3);
        matrix[1][4] = findViewById(R.id.textView1_4);
        matrix[2][0] = findViewById(R.id.textView2_0);
        matrix[2][1] = findViewById(R.id.textView2_1);
        matrix[2][2] = findViewById(R.id.textView2_2);
        matrix[2][3] = findViewById(R.id.textView2_3);
        matrix[2][4] = findViewById(R.id.textView2_4);
        matrix[3][0] = findViewById(R.id.textView3_0);
        matrix[3][1] = findViewById(R.id.textView3_1);
        matrix[3][2] = findViewById(R.id.textView3_2);
        matrix[3][3] = findViewById(R.id.textView3_3);
        matrix[3][4] = findViewById(R.id.textView3_4);
        matrix[4][0] = findViewById(R.id.textView4_0);
        matrix[4][1] = findViewById(R.id.textView4_1);
        matrix[4][2] = findViewById(R.id.textView4_2);
        matrix[4][3] = findViewById(R.id.textView4_3);
        matrix[4][4] = findViewById(R.id.textView4_4);

        update();

        //  Input matrices
        matrixA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                Intent intent = new Intent(MainActivity.this, MatrixActivity.class);
                double[] doubleList = new double[25];
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        doubleList[i * 5 + j] = dataA.getValue(i, j);
                b.putDoubleArray("matrix", doubleList);
                intent.putExtras(b);
                intent.putExtra("columns", dataA.getColumns());
                intent.putExtra("rows", dataA.getRows());
                intent.putExtra("name", 0);
                startActivityForResult(intent, 1);
            }
        });

        matrixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                Intent intent = new Intent(MainActivity.this, MatrixActivity.class);
                double[] doubleList = new double[25];
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        doubleList[i * 5 + j] = dataB.getValue(i, j);
                b.putDoubleArray("matrix", doubleList);
                intent.putExtras(b);
                intent.putExtra("columns", dataB.getColumns());
                intent.putExtra("rows", dataB.getRows());
                intent.putExtra("name", 1);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                int type = data.getIntExtra("name", 0);
                if (type == 0) {
                    this.dataA.setRows(data.getIntExtra("rows", 0));
                    this.dataA.setColumns(data.getIntExtra("columns", 0));
                    double[] doubleList;
                    doubleList = data.getDoubleArrayExtra("matrix");
                    for (int i = 0; i < 5; i++)
                        for (int j = 0; j < 5; j++)
                            this.dataA.setValue(i, j, doubleList[i * 5 + j]);
                }
                else {
                    this.dataB.setRows(data.getIntExtra("rows", 0));
                    this.dataB.setColumns(data.getIntExtra("columns", 0));
                    double[] doubleList;
                    doubleList = data.getDoubleArrayExtra("matrix");
                    for (int i = 0; i < 5; i++)
                        for (int j = 0; j < 5; j++)
                            this.dataB.setValue(i, j, doubleList[i * 5 + j]);
                }
            }
        }
    }

    public void update() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                matrix[i][j].setText(String.valueOf(res.getValue(i, j)));
                matrix[i][j].setTextColor(getResources().getColor(R.color.darkTextColor));
            }
        for (int i = res.getColumns(); i < 5; i++)
            for (int j = 0; j < 5; j++) {
                //matrix[j][i].setInputType(InputType.TYPE_NULL);
                matrix[j][i].setTextColor(getResources().getColor(R.color.colorAccent));
            }
        for (int i = 0; i < 5; i++)
            for (int j = res.getRows(); j < 5; j++) {
                // matrix[i][j].setInputType(InputType.TYPE_NULL);
                matrix[j][i].setTextColor(getResources().getColor(R.color.colorAccent));
            }
    }
}
