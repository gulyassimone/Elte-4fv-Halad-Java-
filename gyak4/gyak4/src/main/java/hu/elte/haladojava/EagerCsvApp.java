package hu.elte.haladojava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This code intentionally has many issues. Please consider it as a bad practice.
 *
 */
public class EagerCsvApp {

  public static void main(String[] args) throws IOException, InterruptedException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));
    List<String[]> values = split(lines);
    List<Integer> heights = extractHeights(values);

    int max = findMax(heights);
    System.out.println(max);
  }

  private static List<String[]> split(List<String> lines) throws InterruptedException {
    List<String[]> values = new ArrayList<>();
    for (int i = 1 /* skip header */; i < lines.size(); i++) {
      if (i % 10_000 == 0) {
        Thread.sleep(100);
      }
      values.add(lines.get(i).split(","));
    }
    return values;
  }

  private static List<Integer> extractHeights(List<String[]> values) throws InterruptedException {
    List<Integer> heights = new ArrayList<>();
    for (int i = 0; i < values.size(); i++) {
      if (i % 10_000 == 0) {
        Thread.sleep(100);
      }
      int height = Integer.parseInt(values.get(i)[3].trim());
      heights.add(height);
    }
    return heights;
  }

  private static int findMax(List<Integer> heights) {
    int max = heights.get(0);
    for (int i = 1; i < heights.size(); i++) {
      int height = heights.get(i);
      if (height > max) {
        max = height;
      }
    }
    return max;
  }
}
