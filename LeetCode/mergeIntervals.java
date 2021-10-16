/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
 */

 class Solution {
    class Interval{
        int start;
        int end;
        
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        // define return type
        int[][] result;
        
        List<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
                int a = intervals[i][0];
                int b = intervals[i][1];
                intervalList.add(new Interval(a,b));
        }
        if(intervalList.size()==1){
            result = new int[1][2];
            result[0][0] = intervalList.get(0).start;
            result[0][1] = intervalList.get(0).end;
            return result;
        }

            
        // sort intervals by start times
        Collections.sort(intervalList, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        List<Interval> mergeIntervals = new ArrayList<>();
        Iterator<Interval> itr = intervalList.iterator();
        Interval interval = itr.next();
        int start = interval.start;
        int end = interval.end;
        int flag = 0;
        if(intervalList.size()==2){
            Interval k = intervalList.get(1);
            if(k.start <= end){
                end = Math.max(end, k.end);
                mergeIntervals.add(new Interval(start, end));
                flag = 1;
            }
            else{
                mergeIntervals.add(new Interval(start, end));
            }
        }
        if(flag!=1)
        while(itr.hasNext()){

            // get new elements interval
            interval = itr.next();
            System.out.println(interval.start+"="+interval.end);
            // if there's an overlap between new intervals element and currents
            if(interval.start <= end){
                end = Math.max(end, interval.end);
                System.out.println(start +"-"+end);
                mergeIntervals.add(new Interval(start, end));
            }
            else{
                System.out.println(start+" * "+end);
                mergeIntervals.add(new Interval(interval.start, interval.end));
                System.out.println(interval.start +"+"+interval.end);
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        //mergeIntervals.add(new Interval(start, end));
        result = new int[mergeIntervals.size()][2];
        for(int i = 0; i< mergeIntervals.size(); i++){
            
            result[i][0] = mergeIntervals.get(i).start;
            result[i][1] = mergeIntervals.get(i).end;
            //System.out.println(result[i][0] + " "+ result[i][1]);
        }
        return result;
    }
}