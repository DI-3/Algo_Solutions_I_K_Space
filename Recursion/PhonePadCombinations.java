public List<String> letterCombinations(String digits) {
        
         // Create the hashMap with the mapping for the buttons
        
        Map<Character, List<Character>> map = new HashMap();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        // _ _ _ 23 2 --> three ways to fill it
        // length of the string
                
        StringBuilder slate = new StringBuilder();
        List<String> result = new ArrayList();
        
        if (digits.length() == 0)
            return result;
                
        buildCombinations(digits, slate, 0, map, result);
                
        return result;
    }
                
                
    public void buildCombinations(String digits, StringBuilder slate, int index, Map<Character, List<Character>> map, List<String> result) {
        
        if (index >= digits.length()) {
            result.add(slate.toString());
            return;
        }
        
        
        for (Character ch : map.get(digits.charAt(index))) {
            slate.append(ch);
            buildCombinations(digits, slate, index + 1, map, result);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
