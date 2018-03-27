
public class 归并排序 {
	public static void main(String[] args)
	{
		int[] array = {9,8,5,6,7,3,1,2,4,0};
		mergeSortUp(array, 0, array.length-1);
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
	}
	
	public static void mergeSortUp(int[] array, int begin, int end)
	{
		if(begin>=end)
			return;
		
		int middle = (begin + end) >> 1;
		mergeSortUp(array, begin, middle);
		mergeSortUp(array, middle+1, end);
		merge(array, begin, middle, end);
	}
	
	public static void merge(int[] array, int begin, int middle, int end)
	{
		int[] tmp    = new int[end - begin + 1];
		int tmpIndex = 0; 
		int index0   = begin;
		int index1   = middle + 1;
		
		while(index0<=middle && index1<=end)
		{
			if(array[index0]>=array[index1])
			{
				tmp[tmpIndex++] = array[index0++];
			}
			else
			{
				tmp[tmpIndex++] = array[index1++];
			}
		}
		
		while(index0<=middle)
			tmp[tmpIndex++] = array[index0++];
		while(index1<=end)
			tmp[tmpIndex++] = array[index1++];
		
		for(int i=0; i<tmp.length; i++)
			array[begin+i] = tmp[i];
	}
}
