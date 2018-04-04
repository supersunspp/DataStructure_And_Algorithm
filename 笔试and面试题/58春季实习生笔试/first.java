
public class first {
	public static void main(String[] args)
	{
		int[] arr = {1,1,-1,-10,11,4,-6,9,20,-10,-1};
		int res   = getMaxSubArray(arr);
		System.out.print(res);
	}
	
	public static int getMaxSubArray(int[] arr)
	{
		if(arr.length<=0)
			return 0;
		
		int maxSum = 0;
		int total  = -1;
		for(int i=0; i<arr.length; i++)
		{
			if(total>=0)
			{
				total += arr[i];
			}
			else
			{
				total = arr[i];
			}
			
			if(total>maxSum)
				maxSum = total;
		}
		
		return maxSum;
	}
}
