
public class KMP {
	public static void main(String[] args)
	{
		String a = "eeeeabcfglks";
		String b = "abc";
		int res  = KMPMatch(a, b);
		System.out.println(res);
	}
	
	public static int KMPMatch(String sStr, String dStr)
	{
		int sLength = sStr.length();
		int dLength = dStr.length();
		int sIndex  = 0, dIndex = 0;
		int[] next  = getNextArray(dStr);
		while(sIndex<sLength && dIndex<dLength)
		{
			if(dIndex==-1 || sStr.charAt(sIndex)==dStr.charAt(dIndex))
			{
				sIndex++;
				dIndex++;
			}
			else
			{
				dIndex = next[dIndex];
			}
		}
		
		if(dIndex==dLength)
			return sIndex - dLength;
		
		return -1;
	}
	
	public static int[] getNextArray(String destStr)
	{
		int[] nextArr = new int[destStr.length()];
		nextArr[0]    = -1;
		int k = -1, j = 0;
		while(j<destStr.length()-1)
		{
			if(k==-1 || destStr.charAt(j)==destStr.charAt(k))
			{
				++k;
				++j;
				nextArr[j] = k;
			}
			else
			{
				k = nextArr[k];
			}
		}
		
		return nextArr;
	}
}
