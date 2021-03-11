package hu.elte.haladojava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;

public class StreamedCsvApp {

  /**
   * Goal: to find the max height (see biostats.csv)
   *
   */
  public static void main(String[] args) throws IOException {
    IntSummaryStatistics max = Files
            .lines(Paths.get(args[0]))
            .skip(1)
            .map(line->line.split(",")).map(cells->cells[2].trim()).mapToInt(heightAsString -> Integer.parseInt(heightAsString))
            .summaryStatistics();
  }
}
