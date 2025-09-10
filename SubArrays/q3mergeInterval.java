import java.util.*;
public class q3mergeInterval {
    public [][]int merge(int[][] intervals)
    {
        //will sort on the basis of starting array ie. a1,a2,a3....
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int k = 0;
        for(int i = 1;i<intervals.length;i++)
        {
            if(intervals[k][1] >= intervals[i][0])
            {
                //will check if in (a1,b1) and (a2,b2) b1>=a2 then it is overlapping 
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            }
            else
            {
                //if not then will move to next index
                k++;
                intervals[k] = intervals[i];
            }
        }
        //copying the array from 0 to k+1 as k is index
        return Arrays.copyOfRange(intervals,0,k+1);
    }
}
