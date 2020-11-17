package Recursion2;

import java.util.ArrayList;
import java.util.List;
/*
recursion 和一维的array
DFS: 有几行，每一行有一个叉，
举个例子如果n = 8，即有8个queens， 这个棋牌应该是8行8列的，所以会有8行，每一行会叉出8列
 */
public class Nqueens {
    //method1: validate the queen position in On each time
    public List<List<Integer>> nqueens(int n){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n == 0){
            return list;
        }
        List<Integer> curRow = new ArrayList<>();
        eightQueens(n, curRow, list);
        return list;
    }
    private void eightQueens(int n, List<Integer> curRow, List<List<Integer>> list){
        //base case: when for all the rows we know where the queen is positioned
        if ( n == curRow.size()){
            list.add(new ArrayList<>(curRow));
            return;
        }
        for ( int i=0; i < n; i++){ // we can try N columns to insert a new queen on this row
            //check if putting a queen at column i at current row is valid
            if (valid(curRow, i)){
                curRow.add(i);
                eightQueens(n, curRow, list); //这里不需要curRow+1，我又不是算所有的肯能性，如果
                //算所有的可能性的话，我需要curRow+1，把每一行都看了，但是这里问的是，把n个queen怎么放进去，就不会
                //和其他的产生冲突，所以我只需要check n行 n列以前的queen是否和现在放的这个quuen冲突；
                curRow.remove(curRow.size() -1);//// row need to reduce the size
            }
        }
    }
    private boolean valid(List<Integer> curRow, int column){
        // j means row
        // need to check all the previous rows,
        // if we put it in the same coloumns or slope == 1 ， return false
        int row = curRow.size();
        for ( int j = 0; j < row; j++){
            if (curRow.get(j) == column || Math.abs(curRow.get(j) - column) == row - j){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueens sol = new Nqueens();
        int n = 4;
        System.out.println(sol.nqueens(n));
    }
}
