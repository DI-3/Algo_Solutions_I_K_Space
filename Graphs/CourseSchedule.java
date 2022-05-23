import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    
    
    static ArrayList<Integer> course_schedule(Integer n, ArrayList<ArrayList<Integer>> prerequisites) {
        // Write your code here.
        int[] inDegreeArr = new int[n];

        // Based on the prereqs build the adjList as well as the indegree
        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0 ; i < n ; i++){
            adjList.set(i, new ArrayList());
        }

        // Build the indegree map as well as the AdjLIst
        for (int i = 0; i < prerequisites.size(); i++){
            inDegreeArr[prerequisites.get(i).get(0)]++;
            adjList.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 0 ; i < inDegreeArr.length; i++){
            if (inDegreeArr[i] == 0){
                q.offer(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList();
        // Lets process the Queue
        while(!q.isEmpty()){

            int course = q.poll();
            ans.add(course);
            // Loop through all the related course
            for (int c : adjList.get(course)){
                inDegreeArr[c]--;
                if (inDegreeArr[c] == 0){
                    q.offer(c);
                }
            }
        }
        if (ans.size() == n){
            return ans;
        }
        return new ArrayList(List.of(-1));
    }
    // we need to dreate a indegree arraylist for each node
}
