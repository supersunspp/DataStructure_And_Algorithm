import java.util.*;
public class Solution {
    Map<String, Integer> map = new LinkedHashMap<>();
    
    public void Insert(char ch)
    {
        if(map.containsKey(String.valueOf(ch)))
        {
            map.put(String.valueOf(ch), map.get(String.valueOf(ch)) + 1);
        }
        else
        {
            map.put(String.valueOf(ch), 1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
                return entry.getKey().charAt(0);
        }
        
        return '#';
    }
}