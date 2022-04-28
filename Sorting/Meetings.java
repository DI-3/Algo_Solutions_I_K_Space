
    /*
    Complete the function below.
    */
    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
        int prev_end = 0;
        int prev_start = 0;
        
        for(List<Integer> interval : intervals ){
            
            if(interval.get(0) > interval.get(1))
                return 0;
            else if(prev_end > interval.get(0) && prev_start < interval.get(1))
                return 0;
            
            prev_end = interval.get(1);
            prev_start = interval.get(0);
        }
        
        return 1;
    }
