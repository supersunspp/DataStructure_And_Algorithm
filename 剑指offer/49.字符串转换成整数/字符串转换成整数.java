public class Solution {
    public static boolean flag;
    public int StrToInt(String str) {
        flag = false;
        if(str==null || str.trim().equals(""))
        {
            flag = true;
            return 0;
        }
        
        int symbol = 0;
        int start  = 0;
        char[] chars = str.trim().toCharArray();
        if(chars[0]=='+')
        {
            start = 1;
        }
        else if(chars[0]=='-')
        {
            start = 1;
            symbol = -1;
        }
        
        int result = 0;
        for(int i=start; i<chars.length; i++)
        {
            if(chars[i]>'9' || chars[i]<'0')
            {
                flag = true;
                return 0;
            }
            
            int sum = result * 10 + (int)(chars[i] - '0');
            
            if((sum - (int)(chars[i]-'0'))/10!=result)
            {
                flag = true;
                return 0;
            }
            
            result = result * 10 + (int)(chars[i] - '0');
        }
        
        result = (int)Math.pow(-1, symbol) * result;
        return result;
    }
}