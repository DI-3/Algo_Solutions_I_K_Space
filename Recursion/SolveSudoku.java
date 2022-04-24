
    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        solveSudoku(board);
        return board;
        //return new ArrayList();
    }
    
    static boolean solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        int row = 0;
        int col = 0;
        boolean isUnfilledFound =false;
        for (int i = 0 ; i < board.size(); i++){
            for (int j = 0; j < board.get(0).size(); j++){
                if (board.get(i).get(j) == 0) {
                    row = i;
                    col =j;
                    isUnfilledFound = true;
                    break;
                }
            }
            if (isUnfilledFound) {
                break;
            }
        }

        if (!isUnfilledFound) {
            return true;
        }

        for (int num = 1 ; num <= 9 ; num++){
            if (isValidPlacing(board, row, col, num)){
                board.get(row).set(col, num);
                if (solveSudoku(board)) {
                    return true;
                } else {
                    board.get(row).set(col, 0);
                }
            }
        }

        return false;
    }


    static boolean isValidPlacing(ArrayList<ArrayList<Integer>> board, int x, int y, int num){

        // Now we need to loop through the puzzle and see this is valid position
        for (int i : board.get(x)){
            if ( i == num){
                return false;
            }
        }

        for (int i = 0 ;  i < board.size(); i++){
            if (board.get(i).get(y) == num){
                return false;
            }
        }


        // 3 * 3 square board
        int x0 = Math.floorDiv(x,3) * 3;
        int y0 = Math.floorDiv(y,3) * 3;

        for (int i = x0; i < x0 + 3; i++){
            for (int j = y0; j < y0 + 3; j++) {
                if (board.get(i).get(j) == num){
                    return false;
                }
            }
        }

        return true;
    }
