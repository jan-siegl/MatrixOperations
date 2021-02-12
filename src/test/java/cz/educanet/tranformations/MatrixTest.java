package cz.educanet.tranformations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private IMatrix a;
    private IMatrix b;
    private IMatrix c;
    private IMatrix d;
    private IMatrix empty;

    @Before
    public void setUp() throws Exception {
        double[][] rawA = {
                {1, 1, 1},
                {1, 1, 1},
        };
        a = MatrixFactory.create(rawA);

        double[][] rawB = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        b = MatrixFactory.create(rawB);
        double[][] rawC = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        c = MatrixFactory.create(rawC);

        double[][] rawEmpty = {};
        empty = MatrixFactory.create(rawEmpty);

        double[][] rawD = {
                {1, 1}
        };
        d = MatrixFactory.create(rawD);
    }

    @Test
    public void getRows() {
        assertEquals(2, a.getRows());
        assertEquals(3, b.getRows());
        assertEquals(3, c.getRows());
        assertEquals(0, empty.getRows());
    }

    @Test
    public void getColumns() {
        assertEquals(3, a.getColumns());
        assertEquals(3, b.getColumns());
        assertEquals(3, c.getColumns());
        assertEquals(0, empty.getColumns());
        assertEquals(2, d.getColumns());
    }

    @Test
    public void times() {
        double[][] rawExpected = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        IMatrix expected = MatrixFactory.create(rawExpected);

        assertNull(a.times(b));
        assertEquals(expected, b.times(c));
    }

    @Test
    public void timesScalar() {
        double[][] rawExpected = {
                {2, 2, 2},
                {2, 2, 2},
        };
        IMatrix expected = MatrixFactory.create(rawExpected);

        assertEquals(expected, a.times(2));
    }

    @Test
    public void add() {
        double[][] rawExpected = {
                {2, 1, 1},
                {1, 2, 1},
                {0, 0, 1},
        };
        IMatrix expected = MatrixFactory.create(rawExpected);

        assertNull(a.add(b));
        assertEquals(expected, b.add(c));
    }

    @Test
    public void get() {
        assertEquals(1, a.get(1, 1), 0);
    }

    @Test
    public void transpose() {
    }

    @Test
    public void determinant() {
    }
}
