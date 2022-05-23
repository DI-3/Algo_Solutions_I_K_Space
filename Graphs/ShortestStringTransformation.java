import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestStringTransformation {

    // bfs solution but first need to build the map

    // ccccc ccccw ccccc

    // don't add the start and stop --> build a function for getting the neighbors know and use it

    // list of neighbors --> change one charater throughout the length and then check if it is in valid set

    // two versions of get neighbors for the flavor of the problem


    // How we measure the complexity --> one approach is for each word -> 26 * len     word * len


    static Set<String> getNeibhors(String word, HashSet<String> wordsSet, String stop){

        Set<String> neighbors = new HashSet();
        char[] wArray = word.toCharArray();
        for (int i = 0 ; i < word.length(); i++){
            char temp = wArray[i];
            for (char ch = 'a' ; ch <= 'z'; ch++){
                if (ch != temp){
                    wArray[i] = ch;
                    String candidateStr = String.valueOf(wArray);
                    if (wordsSet.contains(candidateStr) || candidateStr.equals(stop)){
                        neighbors.add(candidateStr);
                    }
                }
            }
           wArray[i] = temp;
        }
        return  neighbors;
    }

    // word * len * 26       word * word * len

    // Get neighbors second method
    // Loop through each word and then see if the diff btw words are by 1 then there is a connection

    static Set<String> getNeighborsWordDiff(String word, HashSet<String> wordsSet, String stop){

        Set<String> neighbors = new HashSet();

        if (wordDifferByOneChar(word, stop)){
            neighbors.add(stop);
        }
        for (String w : wordsSet) {
            
            if (wordDifferByOneChar(word, w)){
                neighbors.add(w);
            }
        }
        return neighbors;
    }

    static boolean wordDifferByOneChar(String word1, String word2){
        int diff = 0;
        int wIndex1 = 0;

        while(wIndex1 < word1.length() && wIndex1 < word2.length()){
            if (word1.charAt(wIndex1) != word2.charAt(wIndex1)){
                diff++;
            }
            if (diff > 1){
                return false;
            }
            wIndex1++;
        }

        while(wIndex1 < word1.length()){
            diff++;
            wIndex1++;
        }
        while(wIndex1 < word2.length()){
            diff++;
            wIndex1++;
        }

        return diff == 1;
    }

    static ArrayList<String> bfs(ArrayList<String> words, String start, String stop) {

        Queue<String>q = new LinkedList();
        Set<String> visited = new HashSet();
        HashMap<String, String> parent = new HashMap();

        HashSet<String> wordDict = new HashSet<>(words);
        words.remove(start);
        words.remove(stop);


        q.offer(start);
        visited.add(start);

        while(!q.isEmpty()){
            String currWord = q.poll();
            Set<String> neighbors = new HashSet();
            if (26 * currWord.length() < wordDict.size()) {
                neighbors = getNeibhors(currWord, wordDict, stop);
            } else {
                neighbors = getNeighborsWordDiff(currWord, wordDict, stop); 
            }
            for (String s : neighbors){
                if (s.equals(stop)){
                    return createAns(stop, parent, currWord);
                }

                if (!visited.contains(s)){
                    System.out.println(s);
                    visited.add(s);
                    parent.put(s, currWord);
                    q.offer(s);
                }
            }

        }
        return new ArrayList<String>(Arrays.asList("-1"));
    }

    static ArrayList<String> createAns(String stop, HashMap<String, String> pMap, String curr){

        ArrayList<String> ans = new ArrayList();
        ans.add(stop);

        while(pMap.get(curr) != null){
            ans.add(curr);
            curr = pMap.get(curr);
        }
        Collections.reverse(ans);
        return ans;
    }



    static ArrayList<String> string_transformation(ArrayList<String> words, String start, String stop) {
        // Write your code here.
        return bfs(words, start, stop);
    }

}

