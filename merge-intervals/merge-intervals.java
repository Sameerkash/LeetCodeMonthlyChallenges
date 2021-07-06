class Solution {
    public int[][] merge(int[][] intervals) {
        // sort each interval in asecnding order
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(intervals[0]);
        int[] newInterval = intervals[0];
        
        for( int i[] : intervals){
            // The intervals are overlaping, extend the interval
            if(i[0] <= newInterval[1])
                newInterval[1] = Math.max(i[1], newInterval[1]);
            // Disjoint intervals, add the new interval to the list
            else{
                newInterval = i;
                arr.add(newInterval);
            }        
            
        }
            return arr.toArray(new int[arr.size()] []);
        
    }
}