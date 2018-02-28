public class Solution {
    public int JumpFloor(int target) {
        if(target<=0)
        {
            return 0;
        }
        if(target==1)
        {
            return 1;
        }
        if(target==2)
        {
            return 2;
        }
        
        int prePreNum  = 1;
        int preNum     = 2;
        int result     = 0;
        
        for(int i=3; i<=target; i++)
        {
            result    = preNum + prePreNum;
            prePreNum = preNum;
            preNum    = result;
        }
        
        return result;
    }
}