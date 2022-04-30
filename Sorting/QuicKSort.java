import java.util.Random;

public class QuicKSort {
    

    public static int getRandomisedPivotIdex(int start, int end){

        Random rand  = new Random();
        return (rand.nextInt(end-start) + start);
    
    }
    
    public static void QuickS(int[] nums, int start, int end){
       
        if (start >= end)
            return;
    
    
        int iPi = getRandomisedPivotIdex(start, end);
    
        int partitionI = partition(nums, start, end, iPi);
        
        QuickS(nums, start, partitionI);
        QuickS(nums, partitionI + 1, end);
    }
    
/*

  For optimized performance we can actually introduce a 3 way partitioning here
  Similar to the dutch national flag  
    
*/    
    
    public static int partition3way(int[] nums, int start, int end, int ipi) {
        
        swap(nums, start, ipi);
        int pivotElement = nums[start];
        int green = start + 1;
        int white = end;
        
        while(green <= white) {
            
            if (nums[green] < pivotElement){
                green++;
            }else if(nums[white] > pivotElemt){
                white--;
            }else {
                swap(nums, white, green);
                green++;
                white--;
            }    
        }
        
        swap(nums, white, green);
        return white;
        
    }
    
    
    public static int partition(int[] nums, int start, int end, int ipi){
    
        swap(nums, start, ipi);
        int pivotElement = nums[start];
        int orange = start;
    
        for (int green = start; green <= end; green++){
           if (nums[green] < pivotElement) {
               orange++;
               swap(nums, orange, green);
           }    
        }
    
        swap(nums, orange, start);
        return orange;
    }
    
    public static void swap(int[] nums, int i , int j) {
    
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
    
    }

    public static void main(String[] args) {
        
        int[] nums = {3,4,5,6,1,0,11,11,11,11,22};

        QuickS(nums, 0, nums.length - 1);

        for (int i : nums){
            System.out.println(i);
        }


    }

}
