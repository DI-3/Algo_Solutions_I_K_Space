import java.util.Date;
import java.util.HashMap;
import java.util.Map;

 class DataP {
    Integer no;
    Date added;
    public DataP(int n, Date d) {
       no = n;
       added = d;
    }
    @Override
    public String toString() {
      return "DataP [added=" + added + ", no=" + no + "]";
    }
  }

public class MapEntryTRy {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> mp = new HashMap();

        Map<String, Integer> wordFreqMap = new HashMap();
        wordFreqMap.put("THILL", 5);
        wordFreqMap.put("JALLEN", 2);
        wordFreqMap.put("AJONES", 11);

        Map<String, Integer> cricket = new HashMap();
        cricket.put("STEN", 20000);
        cricket.put("VKOHL", 15000);
        cricket.put("SWUAGH", 11000);

        
        mp.put("NFL", wordFreqMap);
        mp.put("CRICKET", cricket);

       // System.out.println("Map is " + mp.entrySet());
        // for (Entry<String, Map<String, Integer>> entry : mp.entrySet()) {

        //     System.out.println("Map is " + entry);

        // }
        Map<String, Map<String, DataP>> mp1 = new HashMap();

        Map<String, Map<String, DataP>> date = new HashMap();

        Map<String, DataP> dateFreqMap = new HashMap();
        dateFreqMap.put("THILL", new DataP(5, new Date()));
        dateFreqMap.put("JALLEN", new DataP(11, new Date()));
        dateFreqMap.put("AJONES", new DataP(5,new Date()));

        Map<String, DataP> cricImpDate = new HashMap();
        cricImpDate.put("STEN", new DataP(5, new Date()));
        cricImpDate.put("VKOHL", new DataP(11, new Date()));
        cricImpDate.put("SWUAGH", new DataP(5,new Date()));

        mp1.put("NFL", dateFreqMap);
        mp1.put("CRICKET", cricImpDate);

        System.out.println(mp1);
    }
}
