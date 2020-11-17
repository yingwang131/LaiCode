package OA;

import java.util.ArrayList;
import java.util.List;


public class IBMGroupingDigits {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
//        arr.add(0);
//        arr.add(1);
//        arr.add(0);
//        arr.add(1);
//        System.out.println(minMoves(arr));
//        System.out.println(minMovesAjacent(arr));
        //1,1,1,1,0,1,0,1
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        System.out.println(minMovesAjacent(arr));
    }

    /**
     * 只能移动相邻的
     * [0,1,0,1]
     * 1
     * [
     *
     * @param arr
     * @return
     */
    public static int minMovesAjacent(List<Integer> arr) {
        int n0 = 0;
        int i0 = 0;
        int n1 = 0;
        int i1 = 0;
        int len = arr.size();
        for (int p = 0; p < len; p++) {
            if (arr.get(p) == 0) {
                n0 += p - i0;
                i0++;
            } else {
                n1 += p - i1;
                i1++;
            }
        }
        return Math.min(n0, n1);
    }
}
