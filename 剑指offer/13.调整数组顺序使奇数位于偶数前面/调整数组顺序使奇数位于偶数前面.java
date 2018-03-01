public class Solution {
    public void reOrderArray(int [] array) {
        if((array==null)||(array.length==0))
        {
            return;
        }
        int i           = 0, j;
        boolean isFirst = true;
        int pre         = 0;
        
        while(i<array.length)
        {
            while((i<array.length)&&!isEven(array[i]))
            {
                i++;
            }
            if(isFirst)
            {
                j = i + 1;
            }
            else
            {
                j = pre + 1;
            }
            
            while(j<array.length&&isEven(array[j]))
            {
                j++;
            }
            
            if(j<array.length)
            {
                int temp = array[j];
                for (int j2 = j-1; j2 >=i; j2--)
                {
                    array[j2+1] = array[j2];
                }
                
                array[i++] = temp;
            }
            else
            {
                break;
            }
        }
    }
    
    public boolean isEven(int n)
    {
        if(n%2==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}