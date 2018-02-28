public class Solution {
    public boolean Find(int target, int [][] array) {
        int len = array.length -1;
        int i   = 0;
        
        while((len>=0)&&(i<array[0].length))
        {
            if(array[len][i]>target)
            {
                len--;
            }
            else if(array[len][i]<target)
            {
                i++;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
}