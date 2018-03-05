public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        if(n==0)
        {
            return 0;
        }
        
        int num = array[0], count = 1;
        for(int i=1; i<n; i++)
        {
            if(array[i]==num)
            {
                count++;
            }
            else
            {
                count--;
            }
            
            if(count==0)
            {
                num   = array[i];
                count = 1;
            }
        }
        
        count = 0;
        for(int i=0; i<n; i++)
        {
            if(array[i]==num)
            {
                count++;
            }
        }
        
        if(count*2 > n)
            return num;
        
        return 0;
    }
}