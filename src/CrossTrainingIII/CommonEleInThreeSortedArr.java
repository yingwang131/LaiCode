package CrossTrainingIII;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/*
Assumptions

The 3 given sorted arrays are not null
There could be duplicate elements in each of the arrays
Examples

A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
 */
public class CommonEleInThreeSortedArr {
   // 还是可以用3个pointer， 谁小移动谁
    public List<Integer> common(int[] a, int[] b, int[] c){
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length){
            if (a[i] == b[j] && b[j] == c[k]){
                result.add(a[i]);
                i++;
                j++;
                k++;
            } else if ( a[i] <= b[j] && a[i] <= c[k]){
                //当是3个数组的时候呀考虑 <= 和具体的写法；
                i++;
            }else if (b[j] <= a[i] && b[j] <= c[k]){
                j++;
            }else {
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonEleInThreeSortedArr sol = new CommonEleInThreeSortedArr();
        int[] a = {1,2,3,3};
        int[] b = {2,3,4,4,5};
        int[] c = {1,1,3,3};
        System.out.println(sol.common(a,b,c));
    }
}
