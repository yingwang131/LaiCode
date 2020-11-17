package MidTerm1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Assumptions

        A is not null and A is not of zero length, so as B
        K > 0 and K <= m * n
        Examples

        A = {1, 3, 5}, B = {4, 8}

        1st smallest s is 1 + 4 = 5
        2nd smallest s is 3 + 4 = 7
        3rd, 4th smallest s are 9 (1 + 8, 4 + 5)
        5th smallest s is 3 + 8 = 11
        第一次期中考试的原题
 */
public class KthSmallestSumInTwoSortedArrays {
    static class Point{
        int x;
        int y;
        int val;
        public Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSum(int[]A, int[]B, int k) {
        Queue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.val == o2.val){
                    return 0;
                }
                return o1.val < o2.val ? -1:1;
            }
        });
        boolean[][]visited = new boolean[k][k];
        queue.offer(new Point(0,0, getVal(A[0],B[0])));
        visited[0][0] = true;

        for ( int i = 0; i < k-1; i++){
            //expand
            Point cur = queue.poll();
            //generate
            if (cur.x + 1 < A.length && !visited[cur.x + 1][cur.y]){
                queue.offer(new Point(cur.x + 1, cur.y, getVal(A[cur.x + 1], B[cur.y])));
                visited[cur.x+1][cur.y] = true;
            }

            if (cur.y + 1 < B.length && !visited[cur.x][cur.y+ 1]){
                queue.offer(new Point(cur.x, cur.y + 1, getVal(A[cur.x],B[cur.y+1])));
                visited[cur.x][cur.y+1] = true;
            }
        }
        return queue.poll().val;
    }
    private int getVal(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        KthSmallestSumInTwoSortedArrays sol = new KthSmallestSumInTwoSortedArrays();
//        int[] A = {1,3,5};
//        int[] B = {2,3};
//        int k = 3;
        int[] A = {1,3,5,8,9};
        int[] B = {2,3,4,7};
        int k = 18;

        System.out.println(sol.kthSum(A,B,k));

    }
}
