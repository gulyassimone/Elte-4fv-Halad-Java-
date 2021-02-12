
package unittesting;  

  import static org.junit.Assert.*;
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;
import org.junit.*;

// javac -cp .:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar FORRÁSFÁJL
// java -cp .:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TESZTELŐ_OSZTÁLY

public class SimpleTest {
  List<Integer> myList;
  Scanner file;

  // @BeforeAll
  // @AfterAll

  @Before
  public void before() {
      file = new Scanner(new File("abc.txt"));

      myList = new LinkedList<>();
      myList.add(1);
      myList.add(2);
      myList.add(3);
      myList.add(4);
      myList.add(901);
      myList.add(-3451);
  }


  @After
  public void after() {
      file.close();
  }

  @org.junit.Test
  public void testTrue() {
    // org.junit.Assert.assertTrue(1 == 1);
    // Assert.assertTrue(1 == 1);
    assertTrue(1 == 1);
  }

  @Test
  public void testFalse() {
    assertFalse(testHelper());
  }

//   @Test
//   public void testFib() {
//     assertTrue(fib(5) == 5);
//   }

  private boolean testHelper() {
      return 0 == 1;
  }

  @Test
  public void manualSuccess() {
    return;
  }

  @Test
  public void manualFail() {
    fail("Always fails");
    assertTrue(1 == 1);
    // assertEquals(5, fib(5));
    // assertEquals(5, fib(5), "fib(5) is 5");
  }

  @Test
  public void wrongFib() {
    // assertEquals(5, fib(5));
    assertEquals("fib(5) is 5", 5, fib(5));

    // rossz sorrend
    // assertEquals(fib(5), 5);
  }

//   @Test
//   public void usualJunitTestCase1() {
//       MyClass myObj = new MyClass(arg1, arg2);
//       myObj.setupForTest(arg3);
//       assertEquals(0, myObj.testedFun(0, ""));
//   }

//   @Test
//   public void usualJunitTestCase1() {
//       MyClass myObj = new MyClass(arg1, arg2);
//       myObj.setupForTest(arg3v2);
//       assertEquals(10, myObj.testedFun(1, "abc"));
//   }

  @Test
  public void testUnexpectedException() {
    throw new RuntimeException("Varatlan hiba tortent");
  }

  @Test(expected = RuntimeException.class)
  public void testExpectedException() {
    throw new RuntimeException("Varakozasnak megfelelo hiba tortent");
  }

//   @Test(expected = IllegalArgumentException.class)
//   public void testNegativeAgeHuman() {
//       new Human(-1);
//   }

//   @Test(expected = IllegalArgumentException.class)
//   public void testGetBestUniversity() {
//       World world = new World();
//       assertEquals(Uni.ELTE, world.getBestUniversity(), "of course");
//   }

  @Test
  public void testExpectedException2() {
    try{
      int x = 3/0;
      fail("Nem történt kivétel");
    } catch(ArithmeticException e){}
  }

  @Test(expected = ArithmeticException.class)
  public void testExpectedException3() {
    int x = 3/0;
  }


  @Test(timeout=2000)
  public void abortWhenInfiniteLoop(){
    while(true){}
  }

  int fib(int fake) { return 100; }



}