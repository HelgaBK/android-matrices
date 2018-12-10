package com.tochanenko.karpyshyn.androidmatrices;

public class SingleMatrix {
    private double[][] values = new double[5][5];
    private int rows;
    private int columns;

    public SingleMatrix(int rows, int columns, double[][] values) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < 5; i++)
            System.arraycopy(values[i], 0, this.values[i], 0, 5);
    }

    public SingleMatrix() {
        this.rows = 5;
        this.columns = 5;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                this.values[i][j] = 0;
    }

    public void setValues(double[][] values) {
        for (int i = 0; i < 5; i++)
            System.arraycopy(values[i], 0, this.values[i], 0, 5);
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return columns;
    }

    public double getValue(int x, int y) {
        if (x < 5 && y < 5)
            return this.values[x][y];
        else
            return 0;
    }

    public void setValue(int x, int y, double number) {
         if (x < 5 && y < 5)
             this.values[x][y] = number;
    }
}
