
    // Complete the function below.
    public static List<List<Integer>> find_combinations(int n, int k) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> slate = new ArrayList<Integer>();
        //NChooseK(nums, slate, k , 0, result);
        NChooseKRange(n, slate, k, 1, result);
        return result;
    }

public static void NChooseKRange(int n,List<Integer> slate, int k, int index, List<List<Integer>> result){
        if (index > n) {
             if (slate.size() == k) {
                 result.add(new ArrayList<Integer>(slate));
             }
             return;
        }
 
        if (slate.size() == k ) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }
 
        NChooseKRange(n, slate, k , index + 1, result);
        slate.add(index);
        NChooseKRange(n, slate, k, index + 1, result);
        slate.remove(slate.size() - 1);
     }