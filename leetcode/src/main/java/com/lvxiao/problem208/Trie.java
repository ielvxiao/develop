package com.lvxiao.problem208;

/**
 * @author lvxiao
 * @date 2020/8/6
 */
public class Trie {

    boolean isEnd;
    Trie[] ts=new Trie[26];
    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie t= this;
        for(int i=0;i<word.length();i++){
            int a = word.charAt(i)-'a';
            Trie[] tmpt = t.ts;
            if(tmpt[a]==null){
                tmpt[a] = new Trie();
            }
            t = tmpt[a];
        }
        t.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie t= this;
        for(int i=0;i<word.length();i++){
            int a = word.charAt(i)-'a';
            Trie[] tmpt = t.ts;
            if(tmpt[a]==null){
                return false;
            }
            t = tmpt[a];
        }
        return t.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie t= this;
        for(int i=0;i<prefix.length();i++){
            int a = prefix.charAt(i)-'a';
            Trie[] tmpt = t.ts;
            if(tmpt[a]==null){
                return false;
            }
            t = tmpt[a];
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.search(prefix);
        boolean param_4 = obj.startsWith(prefix);

    }
}


