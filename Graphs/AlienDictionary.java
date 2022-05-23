class Solution {
    public String alienOrder(String[] words) {
        
        // Lets build the graph from the words given
        Map<Character, List<Character>> adjList  = new HashMap();
        HashMap<Character, Integer> inDegree = new HashMap();
        
        // Initialize the Data Structures
        for (String word :words){
            for (int i = 0 ; i < word.length(); i++){
                adjList.put(word.charAt(i), new ArrayList());
                inDegree.put(word.charAt(i), 0);
            }
        }
        
        // Build the graph
        for (int i = 0 ; i < words.length - 1; i++) {
            // compare the words
            String word1 = words[i];
            String word2 = words[i+1];
            int j = 0;
            
             if (word1.length() > word2.length() && word1.startsWith(word2)) 
                return "";
        
            int length = word1.length() > word2.length() ? word2.length() : word1.length();
            for (; j < length; j++) {
                if (word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree.put(word2.charAt(j), inDegree.getOrDefault(word2.charAt(j), 0) + 1);
                    break;
                }
            }
        }
        
        // Loop through the hashmap keys
         Queue<Character> q = new LinkedList<Character>();
         StringBuilder ans = new StringBuilder();
        
         for (Character ch :inDegree.keySet()) {
             if (inDegree.get(ch) == 0){
                 q.offer(ch);
             }
         }
        
        while(!q.isEmpty()){
            Character ch = q.poll();
            ans.append(ch);
            for (Character neighbor : adjList.get(ch)){
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (newIndeg == 0){
                    q.offer(neighbor);
                }
            }
        }
        
        if (ans.length() == adjList.size()){
            return ans.toString();
        }
        
        return "";
    }
}
