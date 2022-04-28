static ArrayList<ArrayList<Integer>> get_permutations(List<Integer> arr) {

		// Integer array -->
		// 1, 2, 3 -->
		// _ _ _ _ _ _ _ _ _
		
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		makePermutations(arr, result, 0);
		return result;
}

static void makePermutations(List<Integer> arr, ArrayList<ArrayList<Integer>> result, int index) {

	if (index >= arr.size()) {
		result.add(new ArrayList(arr));
		return;
	}
	Set<Integer> hs = new HashSet();
	// for loop to swap each item -- what happens if duplicate then we need to sort
	for (int i = index ;i <  arr.size(); i++) {
		if (hs.contains(arr.get(i))) {
			continue;
		}
		hs.add(arr.get(i));
		swap(arr, i, index);
		makePermutations(arr, result, index + 1);
		swap(arr, i, index);
	}
	
}

static void swap(List<Integer> arr, int i, int j) {
	
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);

}
