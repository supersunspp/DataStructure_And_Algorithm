import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        int numOfZero     = 0;
        int numOfInterval = 0;
        int length        = numbers.length;
        if(length==0)
            return false;
        
        Arrays.sort(numbers);
        for(int i=0; i<length-1; i++)
        {
            if(numbers[i]==0)
            {
                numOfZero++;
                continue;
            }
            if(numbers[i]==numbers[i+1])
                return false;
            
            numOfInterval += numbers[i+1] - numbers[i] - 1;
        }
        
        if(numOfZero>=numOfInterval)
            return true;
        
        return false;
    }
}