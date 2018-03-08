public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i=0; i<length; i++)
        {
            int index = numbers[i];
            if(index>=length)
                index -= length;
            if(numbers[index]>=length)
            {
                duplication[0] = index;
                return true;
            }
            
            numbers[index] = numbers[index] + length;
        }
        
        return false;
    }
}