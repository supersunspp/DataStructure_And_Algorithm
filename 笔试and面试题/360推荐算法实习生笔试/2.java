import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> list               = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++)
		{
			int key = in.nextInt();
			for(int j=0; j<2*key; j++)
				list.add(in.nextInt());
			listAll.add(new ArrayList<Integer>(list));
			list.clear();
		}
		
		for(int i=0; i<listAll.size(); i++)
		{
			ArrayList arr = listAll.get(i);
			if(hepler(arr))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
	
	public static boolean hepler(ArrayList arr)
	{
		quickSort(arr, 0, arr.size()-1);
		int a, b;
		int index;
		boolean flag;
		while(arr.size()!=0)
		{
			a = (int)arr.get(0);
			index = 1;
			flag = false;
			while(index<arr.size())
			{
				if((int)arr.get(index)>a)
				{
					flag = true;
					arr.remove(index);
					break;
				}
				
				index++;
			}
			
			if(!flag)
				return false;
			
			arr.remove(0);
		}
		
		return true;
	}
	
	public static void quickSort(ArrayList arr, int start, int end)
	{
		int index = getPartition(arr, start, end);
		if(index==-1)
			return;
		
		quickSort(arr, start, index-1);
		quickSort(arr, index+1, end);
	}
	
	public static int getPartition(ArrayList arr, int low, int high)
	{
		if(low>=high)
			return -1;
		
		int pivot = (int)arr.get(low);
		while(low<high)
		{
			while((int)arr.get(high)>=pivot && high>low)
				high--;
			arr.set(low, (arr.get(high)));
			
			while((int)arr.get(low)<=pivot && low<high)
				low++;
			arr.set(high, arr.get(low));
		}
		
		arr.set(low, pivot);
		return low;
	}
}
