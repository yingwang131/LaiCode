package HeapGraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumInSortedMatrix2 {
    public int kthSmallest2(int[][] matrix, int k) {
        // Write your solution here
        Queue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value ? -1:1;
            }
        });
        //cell definition, why need comparator
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] generated = new boolean[rows][cols];
        minHeap.offer( new Cell(0,0, matrix[0][0]));
        generated[0][0] = true;// 为了不让之前genenrate过的再generate一遍

        for (int i = 0; i < k -1; i++){
            //expand generate
            Cell cur = minHeap.poll();
            if (cur.row +1 < rows && !generated[cur.row +1][cur.column] ){
                minHeap.offer(new Cell(cur.row +1, cur.column, matrix[cur.row+1][cur.column]));
                generated[cur.row + 1][cur.column] = true;
            }
            if (cur.column +1 < cols && !generated[cur.row][cur.column + 1] ){
                minHeap.offer(new Cell(cur.row , cur.column +1, matrix[cur.row][cur.column +1]));
                generated[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }
    //To define the Cell
     class Cell{
        public int row;
        public int column;
        public int value;

        Cell(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }


    }

    public static void main(String[] args) {
        KthSmallestNumInSortedMatrix2 sol = new KthSmallestNumInSortedMatrix2();
        int[][] matrix = { {1, 3, 5,7}, {2,4,8,9}, {3,5,11,15},{6,8,13,18} };
        int k =  8;
        int result = sol.kthSmallest2(matrix,k);
        System.out.println(result);
    }
}
