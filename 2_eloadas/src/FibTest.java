import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class FibTest {

    @Test
    @ParameterizedTest
    @CsvSource({ "1, 1", "4,5" })
    void fibTest(int expected, int param){
        assertEquals(expected, Fib.fib(param));
    }

    //    @Test
 //   @ParameterizedTest
 //   @CsvSource("2,1,1")
 //   void plusTest(int expected, int param1, int param2){
 //       assertEquals(expected, Fib.plus(param1, param2));
 //   }

}