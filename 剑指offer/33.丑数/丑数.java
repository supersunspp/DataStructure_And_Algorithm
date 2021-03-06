
public class Solution {
	final int d[] = { 2, 3, 5 };
	public int GetUglyNumber_Solution(int index) {
		if(index == 0) 
	        return 0;
		int a[]   = new int[index];
		a[0]      = 1;
		int p[]   = new int[] { 0, 0, 0 };
		int num[] = new int[] { 2, 3, 5 };
		int cur   = 1;
		
		while (cur < index) {
			int m = finMin(num[0], num[1], num[2]);
			if (a[cur - 1] < num[m])
				a[cur++] = num[m];
			p[m]   += 1;
			num[m] = a[p[m]] * d[m];
			}
		return a[index - 1];
	}
	private int finMin(int num2, int num3, int num5) {
		int min     = Math.min(num2, Math.min(num3, num5));
		return min == num2 ? 0 : min == num3 ? 1 : 2;
		}
}
