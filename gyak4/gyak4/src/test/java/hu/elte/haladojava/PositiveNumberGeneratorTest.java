package hu.elte.haladojava;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

import hu.elte.haladojava.lambda.moderate.PositiveNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveNumberGeneratorTest {

  @Test
  public void testCreatePositiveSeriesGenerator() {
    IntSupplier generator1 = new PositiveNumberGenerator().createPositiveSeriesGenerator();
    IntSupplier generator2 = new PositiveNumberGenerator().createPositiveSeriesGenerator();

    Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, IntStream.generate(generator1).limit(3).toArray());
    Assertions.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, IntStream.generate(generator2).limit(5).toArray());
  }
}
