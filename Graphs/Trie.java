import java.util.HashMap;
import java.util.Map;

class TNode {
    Character ch;
    Map<Character, TNode> children = new HashMap();
    boolean endOfWord;
}

public class Trie {




    public void insertWord(TNode node, String word, int i){
        if (i == word.length()){
            node.endOfWord = true;
            return ;
        }

        // Else what we need to add as a trie Node
        if (!node.children.containsKey(word.charAt(i))){
            // create a new TNode
            TNode newNode = new TNode();
            newNode.ch = word.charAt(i);
            node.children.put(word.charAt(i), newNode);
        }
        insertWord(node.children.get(word.charAt(i)), word, i+1);
    }

    public boolean isPresent(String q, TNode node, int i) {

        if (i == q.length()){
            return node.endOfWord;
        }

        // We can still traverse
        if (!node.children.containsKey(q.charAt(i))) {
            return false;
        }

        return isPresent(q, node.children.get(q.charAt(i)), i+1);

    }


    public boolean isPrefixMatch(String q, String prefix, TNode node, int si, int pi) {

        if (pi == prefix.length()){
            return true;
        }
        
        if (si == q.length()){
            return false;
        }

        // We can still traverse
        if (q.charAt(si) == prefix.charAt(pi)){
            return isPrefixMatch(q, prefix, node, si + 1, pi + 1);
        }

        if (prefix.charAt(pi) == '*'){
            return ( 
                      isPrefixMatch(q, prefix, node, si, pi + 1) 
                    || isPrefixMatch(q, prefix, node, si + 1, pi + 1) 
            );
        } else {
            return false;
        }
    }


    public boolean isPrefixMatchWithTrie(TNode node, String prefix, int pi) {

        if (pi == prefix.length()){
            return true;
        }
        
        if (node.children.containsKey(prefix.charAt(pi))) {
            return isPrefixMatchWithTrie(node.children.get(prefix.charAt(pi)), prefix, pi + 1);
        }

        boolean isPrefixMatch = false;
        if (prefix.charAt(pi) == '*') {
            isPrefixMatch = isPrefixMatchWithTrie(node, prefix, pi + 1);
            for (Map.Entry<Character, TNode> e : node.children.entrySet()) {
                isPrefixMatch = isPrefixMatch || isPrefixMatchWithTrie(e.getValue(), prefix, pi);
            }

        }
        return isPrefixMatch;
    }



    public static void main(String[] args) {
        Trie t = new Trie();
        TNode root = new TNode();

        t.insertWord(root, "CATS", 0);
        t.insertWord(root, "DOG", 0);
        t.insertWord(root, "DOGS", 0);

        //System.out.println(t.isPresent("DOGS", root, 0));


        System.out.println(t.isPrefixMatchWithTrie(root, "DO**T", 0));
    }
}


    

