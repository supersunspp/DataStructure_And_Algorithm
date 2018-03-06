public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        int c;
        for(int m=1; m<=n; m*=10)
        {
            int a = n / m, b = n % m;
            if(a%10==1)
                c = 1;
            else
                c = 0;
            ones += ((a + 8) / 10) * m + c * (b + 1);
        }
        
        return ones;
    }
}