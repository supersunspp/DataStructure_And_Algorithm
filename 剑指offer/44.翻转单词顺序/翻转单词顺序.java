public class Solution {
    public String ReverseSentence(String str) {
        if(str==null || str.trim().equals(""))
            return str;
        
        char[] c = str.toCharArray();
        reverse(c, 0, str.length()-1);
        
        int begin = 0;
        int end   = 0;
        while(begin!=c.length)
        {
            if(c[begin]==' ')
            {
                begin++;
                end++;
            }
            else if(c[end]==' ')
            {
                reverse(c, begin, --end);
                begin = ++end;
            }
            else if(end==c.length-1)
            {
                reverse(c, begin, end);
                begin = ++ end;
            }
            else
            {
                end++;
            }
        }
        
        return String.valueOf(c);
    }
    
    public void reverse(char[] c, int begin, int end)
    {
        while(begin<end)
        {
            char temp = c[begin];
            c[begin]  = c[end];
            c[end]    = temp;
            
            begin++;
            end--;
        }
    }
}