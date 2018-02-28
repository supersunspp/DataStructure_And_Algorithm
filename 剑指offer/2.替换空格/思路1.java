public class Solution {
    public String replaceSpace(StringBuffer str) {
    	StringBuffer out = new StringBuffer();
        for(int i=0; i<str.toString().length(); i++)
        {
            char b = str.charAt(i);
            if(String.valueOf(b).equals(" "))
            {
                out.append("%20");
            }
            else
            {
                out.append(b);
            }
        }
        
        return out.toString();
    }
}