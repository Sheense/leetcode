package com.company.tree;

public class 实现Trie前缀树 {
    class Trie {

        private class Node{
            Node[] child = new Node[26];
            boolean has = false;
        }

        private Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node node = root;
            for(int i=0;i<word.length();i++) {
                if(node.child[word.charAt(i) -'a']==null) {
                    node.child[word.charAt(i) - 'a'] = new Node();
                }
                node = node.child[word.charAt(i) - 'a'];
            }
            node.has = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = root;
            for(int i=0;i<word.length();i++) {
                if(node.child[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                node = node.child[word.charAt(i) - 'a'];
            }
            return node.has;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node = root;
            for(int i=0;i<prefix.length();i++) {
                if(node.child[prefix.charAt(i) - 'a'] == null) {
                    return false;
                }
                node = node.child[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }
}
