package hu.elte.haladojava.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.mock;

class WordCounterTest {

    @Test
    public void countWords() {
        FileParser fileParser = mock(FileParser.class); //static import miatt
        Mockito.when(fileParser.lines("file")).thenReturn(Arrays.asList("1" , "2","3"));
        WordCounter underTest = new WordCounter(fileParser);

        int actualWords = underTest.countWords("file");

        Assertions.assertEquals(3, actualWords); // 3?
    }
}