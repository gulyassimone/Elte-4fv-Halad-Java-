package hu.elte.haladojava.stream.easy;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class FindingOnFiniteCollectionTest {

  private FindingOnFiniteCollection tested = new FindingOnFiniteCollection();

  @Test
  public void testFindFirstPrime() {
    Assert.assertEquals(Optional.of(7), tested.findFirstPrime(Arrays.asList(4, 6, 7, 8, 9)));
    Assert.assertEquals(Optional.empty(), tested.findFirstPrime(Arrays.asList(4, 6, 8, 9)));
  }

  @Test
  public void testIsAnyPrime() {
    Assert.assertTrue(tested.isAnyPrime(Arrays.asList(4, 6, 7, 8, 9)));
    Assert.assertTrue(tested.isAnyPrime(Arrays.asList(2)));
    Assert.assertFalse(tested.isAnyPrime(Arrays.asList()));
    Assert.assertFalse(tested.isAnyPrime(Arrays.asList(4, 6, 8, 9, 10)));
  }

  @Test
  public void testIsAllPrime() {
    Assert.assertTrue(tested.isAllPrime(Arrays.asList(3, 5, 7, 11)));
    Assert.assertTrue(tested.isAllPrime(Arrays.asList(2)));
    Assert.assertTrue(tested.isAllPrime(Arrays.asList()));
    Assert.assertFalse(tested.isAllPrime(Arrays.asList(3, 5, 7, 10)));
  }
}
