# https://leetcode.com/problems/add-and-search-word-data-structure-design/


class TrieNode:
    def __init__(self, value):
        self.value = value
        self.children = {}
        self.finish = False

    def add_word(self, value):
        if value in self.children:
            node = self.children[value]
        else:
            node = TrieNode(value)
            self.children[value] = node
        return node

    def find_word(self, value):
        if len(value) == 1:
            if value == '.':
                for v in self.children.values():
                    if v.finish:
                        return True
                else:
                    return False
            else:
                return value in self.children and self.children[value].finish

        head = value[0]
        rest = value[1:]
        if head == '.':
            for v in self.children.values():
                if v.find_word(rest):
                    return True
            else:
                return False
        else:
            if head in self.children:
                return self.children[head].find_word(rest)
            else:
                return False


class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode(None)

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        node = self.root
        l = len(word)
        for i, c in enumerate(word):
            node = node.add_word(c)
            if i + 1 == l:
                node.finish = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: strq
        :rtype: bool
        """
        if not word:
            return False
        return self.root.find_word(word)


# Your WordDictionary object will be instantiated and called as such:

# obj = WordDictionary()
# obj.addWord('word')
# obj.addWord('war')
# obj.addWord('cat')
# obj.addWord('pencil')
# print(obj.search('cat'))
# print(obj.search('pen'))
# print(obj.search('...'))
# print(obj.search('..'))
# print(obj.search('.a.'))
# print(obj.search('..r'))
# print(obj.search('w..'))
# print(obj.search(''))

d = WordDictionary()
d.addWord("bad")
d.addWord("dad")
d.addWord("mad")
print(d.search("pad")) # false
print(d.search("bad")) # true
print(d.search(".ad")) # true
print(d.search("b..")) # true
