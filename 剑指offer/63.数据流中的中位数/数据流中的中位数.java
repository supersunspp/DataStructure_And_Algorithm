import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2)
        {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if(count%2==0)
        {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        }
        else
        {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2==0)
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        else
            return new Double(minHeap.peek());
    }
}