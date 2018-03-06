public class Solution {
    int retNum;
    public int InversePairs(int [] array) {
        if(array==null || array.length<=0)
            return 0;
        
        retNum = 0;
        mergeSortUp(array, 0, array.length-1);
        
        return retNum;
    }
    
    public void mergeSortUp(int[] array, int begin, int end)
    {
        if(begin>=end)
            return;
        
        int middle = (begin + end) >> 1;
        mergeSortUp(array, begin, middle);
        mergeSortUp(array, middle+1, end);
        merge(array, begin, middle, end);
    }
    
    public void merge(int[] arr, int begin, int middle, int end)
    {
        int[] tmp     = new int[end-begin+1];
        int first     = middle;
        int second    = end;
        int tempIndex = tmp.length-1;
        while(first>=begin && second>middle)
        {
            if(arr[first]>arr[second])
            {
                tmp[tempIndex--] = arr[first--];
                retNum += second - middle;
                retNum %= 1000000007;
            }
            else
            {
                tmp[tempIndex--] = arr[second--];
            }
        }
        while(first>=begin)
            tmp[tempIndex--] = arr[first--];
        while(second>middle)
            tmp[tempIndex--] = arr[second--];
        
        for(int i=0; i<tmp.length; i++)
            arr[begin+i] = tmp[i];
    }
}