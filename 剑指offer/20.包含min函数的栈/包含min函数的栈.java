import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public void push(int node) {
        list.add(0, node);
    }
    
    public void pop() {
        list.get(0);
        list.remove(0);
    }
    
    public int top() {
        return list.get(0).intValue();
    }
    
    public int min() {
        int temp = top();
        for(int i=1; i<list.size(); i++)
        {
            if(temp>list.get(i).intValue())
            {
                temp = list.get(i).intValue();
            }
        }
        
        return temp;
    }
}