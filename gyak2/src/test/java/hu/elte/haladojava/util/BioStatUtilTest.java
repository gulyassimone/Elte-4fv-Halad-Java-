package hu.elte.haladojava.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import hu.elte.haladojava.util.BioStatUtil.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BioStatUtilTest {

  InputStream inputStream;

  @BeforeEach
  private void setUp() throws IOException {
    String resourceName = "/biostats.csv";
    URL resource = BioStatUtil.class.getResource(resourceName);
    inputStream = resource.openStream();
  }

 
  @ParameterizedTest(name = "age = {0}, count = {1}")
  @CsvSource({
          "40, 4",
          "100, 0"
  })
  public void testCountOlderThan(int age, int expectedCount) throws IOException {

    int actualCount = BioStatUtil.countOlderThan(age, inputStream);

    Assertions.assertEquals(expectedCount, actualCount);
    //Assertions.assertTrue(4 == actualCount); // logoknál csak annyit ír ki, hogy true vagy false, míg az equals kiírja a 4-es számot is ebben az esetben
    //Assertions.assertSame(4, actualCount); // objektumokat vár, a java beweappeli integerekbe, és megnézi hogy pontosan ugyanazokról az objektumokról van e szó. Referenciát fog nézni.
  }



  @ParameterizedTest(name = "gender = {0}")
  @ValueSource(strings = {"M","F"})
  public void testAverageHeight(String gender) throws IOException {

    double averageHeight = BioStatUtil.averageHeight(Gender.valueOf(gender), inputStream);

    Assertions.assertTrue( averageHeight > 0);
  }

}
