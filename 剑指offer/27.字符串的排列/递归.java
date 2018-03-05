import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.lang.Character;
import java.util.HashSet;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> list = new ArrayList<String>();
       if(str!=null && str.length()>0)
       {
           PermutationHelper(str.toCharArray(),0,list);
           Collections.sort(list);
       }
       
       return list;
    }
    
    public void PermutationHelper(char[] chars, int i, ArrayList<String> list)
    {
        if(i==chars.length-1)
        {
            list.add(String.valueOf(chars));
        }
        else
        {
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i; j<chars.length; ++j)
            {
                if(j==i || !charSet.contains(chars[j]))
                {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i+1, list);
                    swap(chars, i, j);
                }
            }
        }
    }
    
    private void swap(char[] cs,int i,int j)
    {
        char temp = cs[i];
        cs[i]     = cs[j];
        cs[j]     = temp;
    }
}