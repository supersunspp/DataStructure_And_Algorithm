
public class 二分查找 {
	public static void main(String[] args)
	{
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int res     = binarySearch(array, 5);
		System.out.println(res);
	}
	
	public static int binarySearch(int[] array, int k)
	{
		if(array.length<=0)
			return -1;
		
		int begin = 0, end = array.length - 1;
		int mid;
		while(begin<=end)
		{
			mid = (begin + end) >> 1;
		    if(array[mid]==k)
		    	return mid;
		    else if(array[mid]<k)
		    	begin = mid + 1;
		    else
		    	end   = mid - 1;
		}
		
		return -1;
	}
}
