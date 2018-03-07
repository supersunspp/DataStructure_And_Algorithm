import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(sum<=1)
            return lists;
        
        int small  = 1;
        int big    = 2;
        int curSum = 3;
        while(small!=(1+sum)/2)
        {
            while(curSum<sum)
            {
                big++;
                curSum += big;
            }
            
            if(curSum==sum)
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i=small; i<=big; i++)
                {
                    list.add(i);
                }
                lists.add(list);
            }
            
            curSum -= small;
            small++;
        }
        
        return lists;
    }
}