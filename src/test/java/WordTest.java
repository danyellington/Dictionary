import models.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception {
        Word.clearAllWords();
    }

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

    @Test
    public void testWords_correctlyReturned_true() {
        Word testWord = setupNewWord();
        Word otherWord = new Word("bark-machine", "noun", "an animal, canine", "dog");
        assertTrue(Word.getAll().contains(testWord));
        assertTrue(Word.getAll().contains(otherWord));
    }

    public Word setupNewWord() {
        return new Word("meow-machine", "noun", "an animal, feline", "cat");
    }
}
