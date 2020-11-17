package HeapGraphSearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4 [1,2,3,3,4]
the 8th smallest number is 6 [1,2,3,3,4,5,5,6]，即在这个二维数组中，找出前8个最小的元素，然后第八小的也就找出来了
这个题目是BFS2：即best first search（最短距离的算法）
运用了dijkstras 的性质：expand的时候都是值从小到大；所以最后pop出来的元素都是单调递增的
 */
public class KthSmallestNumInSortedMatrix {
    static class Cell {
        int row;
        int column;
        int value;

        Cell(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
    public int kthSmalles(int[][] matrix, int k){
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            //non-static nested class,这个compare 也是anonymous class，有4中：1：实现一个接口 2：定义一个无名类
            // 3：创建一个instance 4：call constructor
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;

            }
        });
        boolean[][]visited = new boolean[row][col];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k -1; i++){
            //先expand
            Cell cur = minHeap.poll();
            if (cur.row + 1 < row && !visited[cur.row+1][cur.column]){
                //offer 2 nodes
                minHeap.offer(new Cell(cur.row+1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row+1][cur.column] = true;
            }
            if (cur.column + 1 < col && !visited[cur.row][cur.column + 1]){
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column+1]));
                visited[cur.row][cur.column+1] = true;
            }
        }
        return minHeap.peek().value;
    }

    public static void main(String[] args) {
        KthSmallestNumInSortedMatrix sol = new KthSmallestNumInSortedMatrix();
        int[][] matrix = { {1, 3, 5,7}, {2,4,8,9}, {3,5,11,15},{6,8,13,18} };
        int k =  8;
        int result = sol.kthSmalles(matrix,k);
        System.out.println(result);
    }
}
