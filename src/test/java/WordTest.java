import models.Word;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void testWord_instantiatesCorrectly_true() {
        Word testWord = setupNewWord();
        assertEquals(true, testWord instanceof Word);
    }

    @Test
    public void testWord_getsEntry_true() {
        Word testWord = setupNewWord();
        assertEquals("meow-machine", testWord.getEntry());
    }

    public Word setupNewWord() {
        return new Word("meow-machine", "noun", "an animal, feline", "cat");
    }
}
