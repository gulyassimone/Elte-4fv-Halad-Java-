package hu.elte.haladojava.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import hu.elte.haladojava.util.BioStatUtil.Gender;

public class BioStatUtilAverageHeightTest {

  private InputStream inputStream;

  // well it is not the best solution, we should close the returning InputStream
  // (preferably in BioStatUtil with Stream.onClose)
  @BeforeEach
  public void setUp() throws IOException {
    String resourceName = "/biostats.csv";
    URL resource = BioStatUtil.class.getResource(resourceName);
    inputStream = resource.openStream();
  }

  @ParameterizedTest(name = "average height of {0}s is {1}")
  @CsvSource({
          "F, 65.57",
          "M, 71.27"
  })
  public void testAverageHeight(Gender inputGender, double expectedAverageHeight) {
    double averageHeight = BioStatUtil.averageHeight(inputGender, inputStream);

    Assertions.assertEquals(expectedAverageHeight, averageHeight, 0.01);
  }
}
