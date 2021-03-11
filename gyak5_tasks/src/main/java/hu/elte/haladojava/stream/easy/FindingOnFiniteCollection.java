package hu.elte.haladojava.stream.easy;

import java.util.List;
import java.util.Optional;

public class FindingOnFiniteCollection {

  public Optional<Integer> findFirstPrime(List<Integer> numbers) {
    return numbers.stream().filter(number -> isPrime(number)).findFirst();
  }

  public boolean isAnyPrime(List<Integer> numbers) {
    return numbers.stream().anyMatch(number -> isPrime(number));
  }

  public boolean isAllPrime(List<Integer> numbers) {
    return numbers.stream().allMatch(this::isPrime);
  }

  private  boolean isPrime(int n ) {
    for (int i = 2; i>= n/2; i++){
      if( n % i == 0){
        return false;
      }
    }
    return true;
  }
}
