
    /*
     * Complete the function below.
     */
    static String[] generate_all_subsets(String s) {
        StringBuilder slate = new StringBuilder();
        List<String> result = new ArrayList<String>();
        
        generateSubsets(s, result, slate, 0);
        
        int i = 0;
        String[] res = new String[result.size()];
        for(String ans : result){
            res[i++] = ans;
        }
        return res;
    }
    
    static void generateSubsets(String s, List<String> result, StringBuilder slate, int index) {
        // n _ _ _ --> abc
        if (index == s.length()) {
            result.add(slate.toString());
            return;
        }
        
        char ch = s.charAt(index);
        generateSubsets(s, result, slate, index + 1);
        slate.append(ch);
        generateSubsets(s, result, slate, index + 1);
        slate.deleteCharAt(slate.length() - 1);
        
    }
