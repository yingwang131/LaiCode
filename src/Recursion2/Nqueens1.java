package Recursion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nqueens1 {
    //method2: validate the queen position in O1 each time
    public List<List<Integer>> nqueensII(int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //cur will be a list of size n, cur[i] is the column number
        // where the queen on row i positioned
        int[] cur = new int[n];
        //record on which columns there is already a queen
        boolean[] usedColumns = new boolean[n];
        //record on which diagonal lines there is already a queen
        boolean[] usedDiagonals = new boolean[2*n -1];
        //record on which reverse diagonal lines there is already a queen
        boolean[] usedRevDiagonals = new boolean[2*n-1];
        helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
        return result;
    }
    private void helper(int n, int row,int[]cur,List<List<Integer>> result,boolean[] usedColumns,boolean[] usedDiagonals,boolean[] usedRevDiagonals){
        //base case
        if (row == n){
            result.add(toList(cur));
            return;
        }

        for (int i = 0; i < n; i++){
            if (valid(n,row,i,usedColumns,usedDiagonals,usedRevDiagonals)){
                mark(n,row,i,usedColumns,usedDiagonals,usedRevDiagonals);
                cur[row] = i;
                helper(n,row+1,cur, result, usedColumns, usedDiagonals,usedRevDiagonals);
                unmark(n,row,i,usedColumns,usedDiagonals,usedRevDiagonals);
            }
        }
    }
    private boolean valid(int n, int row,int column,boolean[] usedColumns,boolean[] usedDiagonals,boolean[] usedRevDiagonals){
        //for the reverse diagonal line, the actual range of column - row is actuall [-(n-1), + (n-1)]
        //we add n-1 to make sure it can fit into the index
        return !usedColumns[column] && !usedDiagonals[column + row] && !usedRevDiagonals[column - row+n-1];
    }
    private void mark(int n, int row,int column,boolean[] usedColumns,boolean[] usedDiagonals,boolean[] usedRevDiagonals) {
        usedColumns[column] = true;
        usedDiagonals[column + row] = true;
        usedRevDiagonals[column - row + n - 1] = true;
    }
    private void unmark(int n, int row,int column,boolean[] usedColumns,boolean[] usedDiagonals,boolean[] usedRevDiagonals) {
        usedColumns[column] = false;
        usedDiagonals[column + row] = false;
        usedRevDiagonals[column - row + n - 1] = false;
    }
    private List<Integer> toList(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int num: array){
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        Nqueens1 sol = new Nqueens1();
        int n = 4;
        System.out.println(sol.nqueensII(n));
    }
}
