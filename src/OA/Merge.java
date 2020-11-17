package OA;

import java.util.Arrays;

public class Merge {
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[2*i] = a[i];
            result[(2*i) +1] = b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2,5,7};
        int[] b = {3,4,6};
        System.out.println(Arrays.toString(merge(a,b)));
        //only merge when the two array have same length;
        String hi = "Ying";
        StringBuilder bui = new StringBuilder();
        StringBuffer buf = new StringBuffer();
        System.out.println(bui.append(hi));

    }
}

