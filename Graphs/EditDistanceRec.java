import java.util.ArrayList;
import java.util.List;

public class EditDistanceRec {
    

    static String s1 = "abat";
    static String s2 = "bad";

    public static void editDist(int i, int j, List<Character> slate, char[] a, char[] b) {

        if (i == a.length || j == b.length){
            System.out.println(String.valueOf(slate));
            return;
        }

        // three options -- insert / delete / replace
        slate.add(b[j]);
        editDist(i+1, j+1, slate, a, b);
        slate.remove(slate.size() - 1);
    
        // inser flow 
        slate.add(b[j]);
        editDist(i, j+1, slate, a, b);
        slate.remove(slate.size()- 1);

        // delete flow
        editDist(i+1, j, slate, a, b);
        
    }

    public static void main(String[] args) {
        
        List<Character> slate = new ArrayList();
        editDist(0,0, slate, s1.toCharArray(), s2.toCharArray());

    }
}
