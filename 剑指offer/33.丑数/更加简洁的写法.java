public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<7)
            return index;
        
        int[] res = new int[index];
        res[0]    = 1;
        int index2=0, index3=0, index5=0, i;
        for(i=1; i<index; i++)
        {
            res[i] = Math.min(res[index2]*2, Math.min(res[index3]*3, res[index5]*5));
            if(res[i]==(res[index2]*2)) index2++;
            if(res[i]==(res[index3]*3)) index3++;
            if(res[i]==(res[index5]*5)) index5++;
        }
        
        return res[index-1];
    }
}