import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tC<=dC && tR<=dR)
        {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
        
        return res;
    }
    
    public void printEdge(int[][] matrix, int tR, int tC, int dR, int dC)
    {
        if(tR==dR)
        {
            for(int i=tC; i<=dC; i++)
                res.add(matrix[tR][i]);
        }
        else if(tC==dC)
        {
            for(int i=tR; i<=dR; i++)
                res.add(matrix[i][tC]);
        }
        else
        {
            int curR = tR;
            int curC = tC;
            while(curC!=dC)
            {
                res.add(matrix[tR][curC]);
                curC++;
            }
            while(curR!=dR)
            {
                res.add(matrix[curR][dC]);
                curR++;
            }
            while(curC!=tC)
            {
                res.add(matrix[dR][curC]);
                curC--;
            }
            while(curR!=tR)
            {
                res.add(matrix[curR][tC]);
                curR--;
            }
        }
    }
}