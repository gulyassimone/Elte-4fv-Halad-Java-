package hu.elte.haladojava.stream.moderate;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListFlatteningTest {

  @Test
  public void testFlatten() {
    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(9, 10);
    
    List<Integer> actualList = new ListFlattening().flatten(Arrays.asList(numbers1, numbers2));
    Assert.assertEquals(Arrays.asList(1, 2, 3, 9, 10), actualList);
  }
}
