
    /*
     * Complete the function below.
     */
    static List<List<Integer>> get_permutations(List<Integer> arr) {
 List<Integer> slate = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        var ans = getPermutationsHelper(arr, slate, 0, result);
        return ans;
    }
public static List<List<Integer>> getPermutationsHelper(List<Integer> arr, List<Integer> slate, int index, List<List<Integer>> ls) {

        if (arr.size() == index) {
            ls.add(new ArrayList<Integer>(slate));
            return ls;
        }

        // 
        List<List<Integer>> result = null;
        for (int i = index ; i < arr.size(); i++) {
            Collections.swap(arr, index, i);
            slate.add(arr.get(index));
            result = getPermutationsHelper(arr, slate, index+1, ls);
            slate.remove(arr.get(index));
            Collections.swap(arr, index, i);
            
        }
        return result;
    }