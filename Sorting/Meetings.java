
    /*
    Complete the function below.
    */
    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
       //  Sort the meetings by the Start time
       //  So a person will be able to attend all the mmeting if
       //. essentially the start time of the second meeting >= end time of previous in the sorted array 
       
       // one thing is can we have the same interval twice if so then we would not be able to attend all meetings
        intervals.sort((x, y) -> Integer.compare(x.get(0), y.get(0)));
        
        List<Integer> prevInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            List<Integer> currInterval = intervals.get(i);
            
            if (currInterval.get(0) < prevInterval.get(1)){
                    return 0;
            }
            prevInterval = currInterval;
        }
        
        return 1;
        
    }
