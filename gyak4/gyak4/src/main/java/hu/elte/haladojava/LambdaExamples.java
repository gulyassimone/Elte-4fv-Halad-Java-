package hu.elte.haladojava;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExamples {

    public static void main(String[] args) {
        function();
        biFunction();
        consumer();
        supplier();
        runnable();
    }

    private static void function() {
        // TODO: replace it with lambda or method reference
        Function<String, Integer> lengthOfString = (string)-> string.length();
        System.out.println("length of 'alma': " + lengthOfString.apply("alma"));
    }

    private static void biFunction() {
        // TODO: replace it with lambda
        BiFunction<LocalDate, LocalDate, Integer> daysBetweenDates = (date1, date2)
                    -> Math.toIntExact(ChronoUnit.DAYS.between(date1, date2));

        System.out.println("days between 'Aranybulla kiadása' and 'Mohácsi csata': " + daysBetweenDates.apply(LocalDate.of(1222, 4, 24), LocalDate.of(1526, 8, 29)));
    }

    private static void consumer() {
        // TODO: replace it with lambda or method reference
        Consumer<Beer> drinker = beer -> {
            beer.drink();
            System.out.println("finom volt!");
        } ;

        // just drinking silently, nothing to print
        drinker.accept(new Beer());
        drinker.accept(new Beer());
        drinker.accept(new Beer());
        // enough
    }

    private static void supplier() {
        // TODO: replace it with lambda or method reference
        Random random = new Random();
        Supplier<Integer> randomNumberSupplier = () -> random.nextInt();

        System.out.println("random number: " + randomNumberSupplier.get());
        System.out.println("random number: " + randomNumberSupplier.get());
        System.out.println("random number: " + randomNumberSupplier.get());
    }

    private static void runnable() {
        // TODO: create your own Runnable-like class where the code can throw checked exception without the need for try-catch
        OwnRunnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    // ouch
                }
            }
        };

        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println("goodbye!");
        }
    }
}

class Student implements Consumer<Beer> {

    @Override
    public void accept(Beer beer) {
        beer.drink();
    }
}

class Beer {
    void drink() {}
}