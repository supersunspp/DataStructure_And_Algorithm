
public class 堆排序 {
	public static void main(String[] args)
	{
		int[] array = {2,1,3,4,5,6,9,8,7,0};
		heapSort(array);
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
	}
	
	public static void heapSort(int[] array)
	{
		if(array.length<=0)
			return;
		
		int length = array.length - 1;
		for(int len=length/2-1; len>=0; len--)
		{
			adjustMaxHeap(array, len, array.length-1);
		}
		
		for(int i=1; i<array.length; i++)
		{
			swap(array, 0, length);
			length--;
			adjustMaxHeap(array, 0, length);
		}
	}
	
	public static void adjustMaxHeap(int[] array, int start, int len)
	{
		if(start>=len)
			return;
		
		int child = start * 2 + 1;
		while(child<=len)
		{
			//System.out.println(start);
			if((child+1)<=len && array[child+1]>array[child])
				child++;
			
			if(array[child]>array[start])
			{
				int tmp      = array[child];
				array[child] = array[start];
				array[start] = tmp;
				start        = child;
				child        = 2 * start + 1;
			}
			else
			{
				return;
			}
		}
	}
	
	public static void swap(int[] array, int i, int j)
	{
		int tmp  = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
