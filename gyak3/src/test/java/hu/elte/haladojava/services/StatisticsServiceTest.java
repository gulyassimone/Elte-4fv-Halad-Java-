package hu.elte.haladojava.services;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatisticsServiceTest {

  private static final String BELA = "Bela";
  private static final String JOZSI = "Jozsi";

  @Test
  public void testCountPersonsWithName_matchingName() {
    // arrange
    FakeDatabase database = new FakeDatabase();
    StatisticsService serviceUnderTest = new StatisticsService(database);

    // act
    int countOfBelas = serviceUnderTest.countPersonsWithName(BELA);

    // assert
    Assertions.assertEquals(1, countOfBelas);
  }

  @Test
  public void testCountPersonsWithName_mismatchingName() {
    // arrange
    FakeDatabase database = new FakeDatabase();
    StatisticsService serviceUnderTest = new StatisticsService(database);
    
    // act
    int countOfJozsis = serviceUnderTest.countPersonsWithName(JOZSI);
    
    // assert
    Assertions.assertEquals(0, countOfJozsis);
  }

  @Test
  public void testCountPersonsWithName_connectionHandling() {
    // arrange
    FakeDatabase database = new FakeDatabase();
    StatisticsService serviceUnderTest = new StatisticsService(database);
    
    // act
    serviceUnderTest.countPersonsWithName("dummy");
    
    // assert
    Assertions.assertTrue(database.isConnectCalled);
    Assertions.assertTrue(database.isDisconnectCalled);
  }

  @Test
  public void testCountPersonsWithName_noInsert() {
    // arrange
    Database database = Mockito.mock(Database.class);
    StatisticsService serviceUnderTest = new StatisticsService(database);
    
    // act
    serviceUnderTest.countPersonsWithName("dummy");
    
    // assert

    Mockito.verify(database).connect();
    Mockito.verify(database).disconnect();

    //megnézi, hogy a metódus hívás létezik -e
  }

  // this is ugly, only for demonstration purposes, we will do it better a bit later!
  static class FakeDatabase implements Database {

    private boolean isConnectCalled;
    private boolean isDisconnectCalled;
    private boolean isInsertInvoked;

    @Override
    public List<Person> findPersonsWithName(String name) {
      if (BELA.equals(name)) {
        return Arrays.asList(new Person(BELA));
      } else {
        return Arrays.asList();
      }
    }
    
    @Override
    public void disconnect() {
      isDisconnectCalled = true;
    }
    
    @Override
    public void connect() {
      isConnectCalled = true;
    }

    @Override
    public void insertPerson(Person person) {
      isInsertInvoked = true;
    }
  }  
}
