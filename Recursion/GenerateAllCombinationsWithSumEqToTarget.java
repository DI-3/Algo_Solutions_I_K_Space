
    // Complete the function below.
    public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> slate = new ArrayList<Integer>();
        Collections.sort(arr);
        collectCombinations(arr, target , 0, result, slate);
        return result;
    }
    
    
    public static void collectCombinations(List<Integer> arr, int target, int index, List<List<Integer>> result, List<Integer> slate){
        
        if (index >= arr.size()) {
            if (target == 0) {
                result.add(new ArrayList(slate));
            }
            return;
        }
        
        // general case
        slate.add(arr.get(index));
        collectCombinations(arr, target - arr.get(index), index + 1, result, slate);
        slate.remove(slate.size() - 1);
        
        while(index + 1 < arr.size() && arr.get(index) == arr.get(index+1)){
            index++;
        }
        collectCombinations(arr, target, index + 1, result, slate);
        
    }