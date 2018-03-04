public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int size = sequence.length;
        if(size==0)
        {
            return false;
        }
        
        int i = 0;
        while((--size)!=0)
        {
            while(i<size && sequence[i++]<sequence[size]);
            while(i<size && sequence[i++]>sequence[size]);
            
            if(i<size)
            {
                return false;
            }
            
            i = 0;
        }
        
        return true;
    }
}