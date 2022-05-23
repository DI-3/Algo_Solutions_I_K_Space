import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ZombiCluster {


    static Integer zombie_cluster(ArrayList<String> zombies) {
        // Write your code here.
        return findClusters(zombies);
    }
    
    
    static class Graph {
        int v;
        HashMap<Character, Set<Character>> adjList = new HashMap();
    }
    
    //"100010"

    static Graph buildGraph(ArrayList<String> zombies) {

        Graph g = new Graph();
        
        for (int i = 0; i < zombies.size(); i++) {
            char[] zconnection = zombies.get(i).toCharArray();
            Set<Character> neighbors = null;

            if (g.adjList.containsKey((char) i)){
                neighbors = g.adjList.get((char) (i + '0'));
            } else {
                neighbors = new HashSet<Character>();
            }

            for (int j = 0 ; j < zconnection.length; j++){
                if ((char) i != (char) j){
                    if (zconnection[j] =='1')  {
                        neighbors.add((char) (j + '0'));
                    }
                }
            }
            g.adjList.put((char) (i + '0'), neighbors);

        }
        return g;
    }

    static void dfs(Graph g, Set visited, Character node) {

        visited.add(node);

        for (Character neighbor : g.adjList.get(node)){
            if (!visited.contains(neighbor)){
                dfs(g, visited, neighbor);
            }
        }
    }

    // start a dfs to find the connected compoents
    static int findClusters(ArrayList<String> zombies) {

        HashSet<Character> visited = new HashSet();
        int noOfClusters = 0;

        Graph g = buildGraph(zombies);
        
        // Loop through all the nodes and see
        for (int i = 0 ; i < zombies.size(); i++){
            if (!visited.contains((char) (i + '0'))){
                dfs(g, visited, (char) (i + '0'));
                noOfClusters++;
            }
            
        }

        return noOfClusters;
    }
}
