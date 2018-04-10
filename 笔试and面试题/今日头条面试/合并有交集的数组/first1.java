import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class first1 {
	public static void main(String[] args)
	{
		int[][] arr = {{1, 3}, {2, 6}, {5, 7}, {8, 10}};
		ArrayList<ArrayList<Integer>> res = merge(arr);
		
		for(int i=0; i<res.size(); i++)
		{
			System.out.println(res.get(i));
		}
	}
	
	public static ArrayList<ArrayList<Integer>> merge(int[][] arr)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer>           list = new ArrayList<Integer>();
		if(arr.length<=0)
			return res;
		
		LinkedHashMap<Integer, int[]> map = new LinkedHashMap<Integer, int[]>();
		for(int i=0; i<arr.length; i++)
		{
			if(map.containsKey(arr[i][0]))
			{
				if(arr[i][1]>map.get(arr[i][0])[1])
					map.put(arr[i][0], arr[i]);
			}
			else
			{
				map.put(arr[i][0], arr[i]);
			}
		}
		
		int[] start = new int[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			start[i] = arr[i][0];
		}
		
		Arrays.sort(start);
		int[][] tmp = new int[start.length][2];
		for(int i=0; i<start.length; i++)
		{
			tmp[i] = map.get(start[i]);
		}
		int j;
		for(int i=0; i<tmp.length;)
		{
			list.clear();
			for(j=i+1; j<tmp.length; j++)
			{
				if(tmp[j][0]>tmp[i][1] || tmp[j][1]<tmp[i][0])
					break;
				
				if(tmp[j][0]>tmp[i][0] && tmp[j][0]<tmp[i][1] && tmp[j][1]>tmp[i][1])
					tmp[i][1] = tmp[j][1];
				else if(tmp[j][0]<tmp[i][0] && tmp[j][1]<tmp[i][0] && tmp[j][1]<tmp[i][1])
					tmp[i][0] = tmp[j][0];
				else
					continue;
			}
			
			list.add(tmp[i][0]);
			list.add(tmp[i][1]);
			i = j;
			System.out.println(i);
			res.add(new ArrayList<Integer>(list));
		}
		
		
		return res;
	}
}
