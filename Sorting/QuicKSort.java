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
