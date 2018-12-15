package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import solutions.Problem211.WordDictionary;

class Problem211Test {
    @Test
    void testAddWord() {
        WordDictionary dict = new WordDictionary();
        dict.addWord("cat");
        assertTrue(dict.search("cat"));
    }

    @Test
    void testFuzzySearch() {
        WordDictionary dict = new WordDictionary();
        dict.addWord("cat");
        dict.addWord("caterpillar");
        assertTrue(dict.search("c.."));
        assertTrue(dict.search("..t"));
        assertTrue(dict.search("..."));
        assertFalse(dict.search("cat.."));
        assertFalse(dict.search(""));
    }

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
