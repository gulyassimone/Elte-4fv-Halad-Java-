package hu.elte.haladojava.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {

    @Test
    public void matrixAddTest(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Matrix matrixA = new Matrix(1,2);
            Matrix matrixB = new Matrix(3,4);
            matrixA.add(matrixB);
        });
    }
}
