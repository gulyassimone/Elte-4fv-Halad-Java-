package hu.elte.haladojava.services;

import java.util.List;

public class StatisticsService {

  // test it!
  public int countPersonsWithName(String name) {
    Database database = new DatabaseImpl();
    database.connect();
    List<Person> persons = database.findPersonsWithName(name);
    int count = persons.size();
    database.disconnect();
    return count;
  }
}
