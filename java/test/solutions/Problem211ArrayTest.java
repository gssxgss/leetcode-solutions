package solutions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import solutions.Problem211Array.WordDictionary;

class Problem211ArrayTest {

    @Test
    void leetCodeTest() {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        assertFalse(dict.search("pad"));
        assertTrue(dict.search("bad"));
        assertTrue(dict.search(".ad"));
        assertTrue(dict.search("b.."));
    }

}