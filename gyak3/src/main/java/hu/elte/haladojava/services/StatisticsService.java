package hu.elte.haladojava.services;

import java.util.List;

public class StatisticsService {

  private final Database database;
  
  StatisticsService(Database database) {
    this.database = database;
  }

  public int countPersonsWithName(String name) {
    database.connect();
    List<Person> persons = database.findPersonsWithName(name);
    int count = persons.size();
    database.disconnect();
    return count;
  }
}
