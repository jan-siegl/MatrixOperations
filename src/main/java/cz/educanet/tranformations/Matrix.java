package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (matrix.getColumns() != this.getRows()) return null;
        double[][] result = new double[matrix.getRows()][this.getColumns()];
        for (int x = 0; x < matrix.getRows(); x++) {
            for (int y = 0; y < this.getColumns(); y++) {
                for (int i = 0; i < matrix.getColumns(); i++) {
                    result[x][y] += matrix.get(x, i) * rawArray[i][y];
                }
            }
        }
        return MatrixFactory.create(result);
    }

    @Override
    public IMatrix times(Number scalar) {
        int columns = this.getColumns();
        int rows = this.getRows();
        double[][] result = new double[rows][columns];
        for (int x = 0; x < rows; x++)
            for (int y = 0; y < columns; y++) {
                result[x][y] = rawArray[x][y] * scalar.doubleValue();
            }
        return MatrixFactory.create(result);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        int columns = this.getColumns();
        int rows = this.getRows();
        if (columns != matrix.getColumns() || rows != matrix.getRows()) return null;
        double[][] result = new double[rows][columns];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) result[x][y] = rawArray[x][y] + matrix.get(x, y);
        }
        return MatrixFactory.create(result);
    }

    @Override
    public double get(int n, int m) {
        return rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }

    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;

        for (int i = 0; i < rawArray.length; i++) {
            if (!Arrays.equals(rawArray[i], matrix.rawArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
