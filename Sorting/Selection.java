// Complete the function below.
    public static int kth_largest_in_an_array(List<Integer> numbers, int k) {
        // Finding the Kth largest
        
        // How to solve this --> 0(n)
        // nlogn
        
        // Quick-Select --> 
        
        // n-k th position -->
        
        
        quickSelect(numbers, numbers.size() - k , 0, numbers.size() - 1);
        
        return numbers.get(numbers.size() - k);
        
        
    }
    
    
    public static int getPivotIndex(int start, int end){

        Random random = new Random();
        return random.nextInt(end - start) + start;
    }

    public static void swap(List<Integer> numbers, int i, int j){
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }


    public static int partition(List<Integer> numbers, int start, int end, int pivotIndex){

        swap(numbers, start, pivotIndex);
        int pivotElement = numbers.get(start);

        int orange = start;
        for (int green = orange + 1; green <=end; green++){
             if (numbers.get(green) <= pivotElement){
                 orange++;
                 swap(numbers, green, orange);
             }
        }
        swap(numbers, start, orange);
        return orange;
    }

    public static  void  quickSelect(List<Integer> numbers, int k, int start, int end) {
        
        if (start >= end)
            return;
        
        // select an element -- randomly and then go about placing it exact position 
        int pivotIndex = getPivotIndex(start, end);
        int pIndex = partition(numbers, start, end, pivotIndex);

        if (pIndex == k) {
            return ;
        } else if (pIndex > k) {
            quickSelect(numbers, k, start, pIndex - 1);
        } else {
            quickSelect(numbers, k, pIndex + 1, end); 
        }
    }
