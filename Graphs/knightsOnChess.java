    /*
     * Complete the function below.
     */
    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.
        // Graph problem
        //   0 1 2 3 4
        // 0 _ _ _ _ _ _ _ _
        // 1 _ _ _ _ _ _ _ _
        // 2 _ _ _ _ _ _ _ _
        // 3 _ _ _ _ _ _ _ _
        // 4 _ _ _ _ _ _ _ _
        if (start_row == end_row && start_col == end_col) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2},{1, -2}, {-1,-2}};
        
        Queue<int[]> q = new LinkedList<int[]>();
        visited[start_row][start_col] = true;
        
        q.offer(new int[]{start_row, start_col});
        int moves = 0;
        while(!q.isEmpty()){
            int length = q.size(); 
            moves++;
            for (int i = 0 ; i < length; i++){
              int[] node = q.poll();
              for (int[] neighbor : getNeighbors(node[0], node[1], rows, cols)){
               if (!visited[neighbor[0]][neighbor[1]]){
                  
                  if (neighbor[0] == end_row && neighbor[1] == end_col){
                      return moves;
                  }
                  visited[neighbor[0]][neighbor[1]] = true;
                  q.offer(new int[]{neighbor[0], neighbor[1]});
                  
               }  
             }
             
            }
            
        }
        return -1;
    }
    
    public static List<int[]> getNeighbors(int row, int col, int rows, int cols){
       int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2},{1, -2}, {-1,-2}};
       List<int[]> neighbors = new ArrayList<int[]>();
       for (int[] dir : directions){
             if (row + dir[0] >=0 && row + dir[0] < rows && col + dir[1] >= 0 && col + dir[1] < cols){
                 neighbors.add(new int[] {row + dir[0], col + dir[1]});
             }      
       }
       return neighbors;        
    }

    // x = 2  y = 1
    // x = 2  y = -1
    // x = -2 y = 1
    // x = -2 y = -1
    // x = 1  y = 2
    // x = 1  y = -2
    // x = -1 y = 2
    // x = -1 y = -2
