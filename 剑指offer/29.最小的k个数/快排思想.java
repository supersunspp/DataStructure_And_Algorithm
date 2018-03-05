import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    private int getPartition(int[] array, int start, int end)
    {
        int low     = start;
        int high    = end;
        int pivot = array[low];
        while(low<high)
        {
            while(low<high && pivot<=array[high])
            {
                high--;
            }
            array[low] = array[high];
            while(low<high && pivot>=array[low])
            {
                low++;
            }
            array[high] = array[low];
        }
        
        array[low] = pivot;
        return low;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int len = input.length;
        if(len==0 || k>len)
        {
            return new ArrayList<Integer>();
        }
        if(len==k)
        {
            ArrayList<Integer> res1 = new ArrayList<Integer>();
            for(int i=0; i<input.length; i++)
            {
                res1.add(input[i]);
            }
            
            return res1;
        }
        
        int start = 0;
        int end   = len - 1;
        int index = getPartition(input, start, end);
        while(index!=(k-1))
        {
            if(k<=0)
            {
                break;
            }
            if(index > k-1)
            {
                end   = index - 1;
                index = getPartition(input, start, end);
            }
            else
            {
                start = index + 1;
                index = getPartition(input, start, end);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<k; i++)
        {
            res.add(input[i]);
        }
        return res;
    }
}