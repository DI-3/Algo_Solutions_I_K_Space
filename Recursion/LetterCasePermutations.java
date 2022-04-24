
    // Complete the function below.
    public static List<String> letter_case_permutations(String str) {
        List<String> result = new ArrayList<String>();
        char[] slate = new char[str.length()];
        generateLetterCasePerms(str, slate, 0,  result);
        return result;
    }
    
    public static void generateLetterCasePerms(String str,char[] slate, int index, List<String> result ) {
        if (index == str.length()) {
            result.add(new String(slate));
            return;
        }
        
        char ch = str.charAt(index);

        if (Character.isLetter(ch)){
            slate[index] = Character.toUpperCase(ch);
            generateLetterCasePerms(str, slate, index + 1, result);
            slate[index] = Character.toLowerCase(ch);
            generateLetterCasePerms(str, slate, index + 1, result);
            //slate[index] = '\0';
        } else {
            slate[index] = ch;
            generateLetterCasePerms(str, slate, index + 1, result);
        } 
        
        
    }
