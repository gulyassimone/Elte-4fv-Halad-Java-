package hu.elte.haladojava.generic;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

public class GenericMethods {

    public OptionalInt max(int[] ints) {
        return null; // TODO
    }

    public Optional<Integer> max(Integer[] ints) {
        new ArrayList<Integer>();
        if (ints.length == 0) {
            return Optional.empty();
        }

        Integer max = ints[0];
        for (Integer i : ints) {
            if (i > max) {
                max = i;
            }
        }
        return Optional.of(max);
    }

    public Optional<String> max(String[] strings) {
        if (strings.length == 0) {
            return Optional.empty();
        }

        String max = strings[0];
        for (String s : strings) {
            if (s.compareTo(max) > 0) {
                max = s;
            }
        }
        return Optional.of(max);
    }
}
