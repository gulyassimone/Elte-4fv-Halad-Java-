package hu.elte.haladojava.stream.easy;

import java.util.List;
import java.util.stream.Collectors;

public class NaturalStreamSorting {

  // hint: use .collect() and the right method from java.util.stream.Collectors
  public List<String> sortNamesAlphabetically(List<String> names) {
    return names.stream().sorted().collect(Collectors.toList());
  }
}
