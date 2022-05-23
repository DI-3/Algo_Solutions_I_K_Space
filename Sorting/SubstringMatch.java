import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringMatch {
    
    // String Problems

    // 1 - Substring within control set
    // 2 - Substring match - brute force
    // 3 - Longest substring Palindrome
    // 4 - Numernym - largest number
    // 5 - Get Longest substring with two distinct chars
    
    
    // Given a string s of length n, find the length of the longest substring that contains exactly two distinct characters.

    // {
    //     "s": "ecebaaaaca"  6


    // }
    static Integer get_longest_substring_length_with_exactly_two_distinct_chars(String s) {
        // Write your code here.
        // Question "s": "ecebaaaaca" Answer = 6
        
        //
        // Window of length 3 -->
        Map<Character, Integer> charMap = new HashMap<>();
        int windowEnd = 0;
        int substringLen = 0;
        int windowStart = 0;

        while(windowEnd < s.length()){
            char ch = s.charAt(windowEnd);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
           
            while(charMap.size() > 2){

                charMap.put(s.charAt(windowStart), charMap.get(s.charAt(windowStart)) - 1);

                if (charMap.get(s.charAt(windowStart)) == 0){
                    charMap.remove(s.charAt(windowStart));
                }
                windowStart++;
            }

            if (charMap.size() ==2){
                substringLen = Math.max(substringLen, windowEnd - windowStart + 1);
            }


            windowEnd++;
        }



        return substringLen;
    }

    // 1 - Control Set -> Shortest substring with all the characters in the control set

    public static void controlSetMatch() {
        String input = "achbdeckbthedatafor";
        String sub = "thedas";
        Set<Character> check = new HashSet(){{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
        }};
        
       int min = Integer.MAX_VALUE;
       for (int i = 0 ; i < input.length(); i++){
            Set<Character> copy =  new HashSet(check);
            for (int j = i ; j <  input.length(); j++){
                copy.remove(input.charAt(j));
                if (copy.isEmpty()){
                    min = Math.min(min, j - i +1);
                }
            }
       }
       System.out.println(min);
    }


    public static void substringMatch() {
        String input = "achbdeckbthedatafor";
        String sub = "thedas";
         
       for (int i = 0 ; i < (input.length() - sub.length()); i++){
            int j = 0;
            for (; j < sub.length(); j++){
               if (sub.charAt(j) != input.charAt(i + j)){
                   break;
               }
           }
           if (j == sub.length()){
               System.out.println("SubstringMatched");
           }
       }
    }


    static void genNumer(String word, List<Character> slate, int index, List<String> res) {
        // n  a  i  l  e  d
        for (int i = 2 ; i <= word.length() - 2; i++){
            for (int j = 1; j  <=  word.length() - 1 - i ; j++){
                // get the substring upto j and then append the 
                String sub = word.substring(0, j) + i + word.substring(i+j, word.length());
                System.out.println(sub);
            }
        }
    }




    public static void longestPalindromeSubString() {

        // 1) O(n*2) --> for generating all the substring
        // 2) then we need O(n) -> to check if is palindrome

        // can we check with a sliding window -->

        // c_  a_ m_ a_ g_ h_ l_ r_ t_ 

    }

    static List<String> generate_all_numeronyms(String word) {

        List<String> res = new ArrayList();
        List<Character> slate = new ArrayList();
        slate.add(word.charAt(0));
        genNumer(word, slate, 1, res);
        // Write your code here.
        //System.out.println(res);
        return res;
    
    
    }

    public static void main(String[] args) {
        
        // controlSetMatch();
        // generate_all_numeronyms("nailed");
        System.out.println(get_longest_substring_length_with_exactly_two_distinct_chars("ecebaaaaca"));
       
    }
}









// Given a word, generate all possible numeronyms for it.

// What is a numeronym?

// A numeronym is a word where a number is used to form an abbreviation.

// A numeronym for a word is another word with two or more contiguous letters replaced with their number. Exactly one set of contiguous letters is replaced by a number. 
// First or last letter in the initial word are never omitted/replaced when forming a numeronym for it.

// nailed --> ["n4d", "na3d", "n3ed", "n2led", "na2ed", "nai2d"]

