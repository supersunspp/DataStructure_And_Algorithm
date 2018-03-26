
public class quickSort {
    public static void main(String[] args)
    {
    	int[] array = {2,1,3,4,5,6,9,8,7,0};
    	quickSort(array, 0, array.length-1);
    	for(int i=0; i<array.length; i++)
    		System.out.println(array[i]);
    }
    
    public static int getPartition(int[] array, int low, int high)
    {
    	if(low>=high)
    		return -1;
    	
    	int pivot = array[low];
    	while(low<high)
    	{
    		//System.out.println(high);
    		while(array[high]>=pivot && high>low)
    		{
    			high--;
    			//System.out.println(high);
    		}
    		array[low]  = array[high];
    		
    		while(array[low]<=pivot && low<high)
    			low++;
    		array[high] = array[low];
    	}
    	
    	array[low] = pivot;
    	return low;
    }
    
    public static void quickSort(int[] array, int start, int end)
    {
    	int index = getPartition(array, start, end);
    	if(index==-1)
    		return;
    	quickSort(array, start, index-1);
    	quickSort(array, index+1, end);
    }
}
