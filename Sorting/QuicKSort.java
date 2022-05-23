import java.util.ArrayList;
import java.util.Collections;
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
        
        QuickS(nums, start, partitionI - 1);
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
        
        swap(nums, white, start);
        return white;
        
    }
    
    
    public static int partition(int[] nums, int start, int end, int ipi){
    
        swap(nums, start, ipi);
        int pivotElement = nums[start];
        int white = end;
        int green = start + 1;
        while(green <= white) {
           if (nums[green] < pivotElement) {
               green++;
           }else if(nums[white] > pivotElement){
                white--;
           }else{
                swap(nums, white, green);
                green++;
                white--;
           }
        }
        swap(nums, white, start);
        return white;
    }
    
    public static void swap(int[] nums, int i , int j) {
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
    
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,0,11,22,22,11,11,01,11,121};
        QuickS(nums, 0, nums.length - 1);

        for (int i : nums){
            System.out.println(i);
        }
    }
}


 
   // For your reference:
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    static Integer find_single_value_trees(BinaryTreeNode root) {
        // Write your code here.
        return 0;
       
        Ans ans = new Ans();
        univalueCount(root, ans);
    }
    class Ans {
        int count;
    }

    static boolean univalueCount(BinaryTreeNode node, Ans ans) {

        if (node == null){
            ans.count++;
            return true;
        }
       
        // 
        boolean isLeftUVal = false;
        isLeftUVal = univalueCount(node.left, ans);

        boolean isRightUVal = false;
        isRightUVal = univalueCount(node.left, ans);

        if (isLeftUVal && isRightUVal && (node.value == node.right.value && node.value == node.left.value)){
            ans.count++;
            return true;
        }
        return false;
    }