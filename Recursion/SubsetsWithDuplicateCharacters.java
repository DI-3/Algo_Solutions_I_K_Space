// Complete the function below. 
    public static ArrayList<String> get_distinct_subsets(String str) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder slate = new StringBuilder();
        char[] tempInput = str.toCharArray();

        // Sorting is important --> 
        Arrays.sort(tempInput);
        distinctSubsetHelper(new String(tempInput), slate, 0, result);
        return result;
    }
    
    // a b c  -- { a } { b } { c } { }  -->  _ _ _  2 * 2 * 2  _ [ _ _ ]  
    
    public static void distinctSubsetHelper(String ip, StringBuilder slate, int index, ArrayList<String> result){
	// Base case first -->
	if(index >= ip.length()){
		result.add(new String(slate.toString()));
		return ;
	}
	// a a b
 	int count = 0;
    	for (int i = index + 1; i < ip.length(); i++){
    		if (ip.charAt(i) != ip.charAt(index)){
    		break;
    	}
    	count++;
    }

    // Exclusion and inclusion
    distinctSubsetHelper(ip, slate, index + count + 1, result);

    // inclusion case   // abbbc
    for (int i = 0; i <= count; i++){
       slate.append(ip.charAt(index));
       distinctSubsetHelper(ip, slate, index + count + 1 , result);
    }

    // Remove all the additional characters added
    for (int i = 0 ; i <= count; i++){
    	slate.deleteCharAt(slate.length() - 1);
    }
}
