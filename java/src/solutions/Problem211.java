// https://leetcode.com/problems/add-and-search-word-data-structure-design/
package solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem211 {

    public static void main(String[] args) {
        System.out.println("211. Add and Search Word - Data structure design");
    }

    private static class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean isFinish;

        /**
         * Initialize Trie Node
         */
        TrieNode() {
            this.isFinish = false;
            this.children = new HashMap<>();
        }

        /**
         * Add Word to TrieNode
         *
         * @param word String to add
         */
        void addWord(String word) {
            if (word.length() == 1) {
                char head = word.charAt(0);
                TrieNode node = setTrieNode(head);
                node.isFinish = true;

            } else {
                char head = word.charAt(0);
                String rest = word.substring(1);
                TrieNode node = setTrieNode(head);
                node.addWord(rest);
            }
        }

        /**
         * Get or Create a TrieNode
         *
         * @param character A character in the word
         * @return A TrieNode
         */
        private TrieNode setTrieNode(char character) {
            TrieNode node;
            if (this.children.containsKey(character)) {
                node = this.children.get(character);
            } else {
                node = new TrieNode();
                this.children.put(character, node);
            }
            return node;
        }

        /**
         * Search if character in TrieNode.children
         *
         * @param string A string to search
         * @return if string in children
         */
        boolean search(String string) {
            if (string.length() == 1) {
                char character = string.charAt(0);
                if (character == '.') {
                    for (TrieNode node : this.children.values()) {
                        if (node.isFinish) return true;
                    }
                    return false;
                }
                return this.children.containsKey(character) && this.children.get(character).isFinish;
            }

            char head = string.charAt(0);
            String rest = string.substring(1);
            if (head == '.') {
                for (TrieNode node : this.children.values()) {
                    if (node.search(rest)) return true;
                }
                return false;
            }
            return this.children.containsKey(head) && this.children.get(head).search(rest);

        }
    }

    public static class WordDictionary {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            if (word.length() == 0) return;
            this.root.addWord(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word.length() == 0) return false;
            return this.root.search(word);
        }
    }
}

