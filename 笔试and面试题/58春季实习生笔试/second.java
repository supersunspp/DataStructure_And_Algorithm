
public class second {
	public static void main(String[] args)
	{
		String str = "abbcccddeefffgggcc";
		findSubStr(str, 2);
	}
	
	public static void findSubStr(String str, int k)
	{
		if(str.length()<k)
			return;
		
		int j;
		int count;
		for(int i=0; i<str.length();)
		{
			j = i + 1;
			count = 1;
			while(j<str.length())
			{
				if(str.charAt(i)!=str.charAt(j))
					break;
				j++;
				count++;
			}
			
			
			if(count==k)
			{
				System.out.printf("%d, %d, %s", i, i+k, str.substring(i, i+k));
				System.out.println("\n");
			}
			
			i += count;
		}
	}
}
