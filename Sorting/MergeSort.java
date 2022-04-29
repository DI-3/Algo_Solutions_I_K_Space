public class MergeSort {
    public static void mergeSort(int[] nums, int start, int end) {
  
        if (start >= end){
          return;
        }
      
        int mid = (end - start) / 2  + start;
      
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
      
        merge(nums, start, end, mid);
      
      }
      
    public static void merge(int[] nums, int start, int end, int mid) {
        
        int[] aux = new int[end - start + 1];
        int i = start, j = mid + 1, auxIndex = 0;
      
        while(i <=  mid && j <= end){
          if (nums[i] <= nums[j]) {
            aux[auxIndex++] = nums[i++];
          } else {
            aux[auxIndex++] = nums[j++];
          }
        }
      
        while(i <= mid){
          aux[auxIndex++] = nums[i++];
        }
        while(j <= end){
          aux[auxIndex++] = nums[j++];
        }
      
        auxIndex = 0;
        // fill the original array
        for (int k = start; k <= end; k++){
          nums[k] = aux[auxIndex++];
        }
      
      }
      
      public static void main(String[] args) {

        int[] nums = {1,7,8,9,0,1,12,33,55,23,11,56,78,99};

        mergeSort(nums, 0, nums.length -1);

        for (int i : nums){
            System.out.println(i);
        }
          
      }
}


// 1,7,8,9,0   1,12, 33,55

// 1,7,8 9 0    1,12, 33,55