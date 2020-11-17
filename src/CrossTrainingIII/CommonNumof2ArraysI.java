package CrossTrainingIII;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Assumptions

Both arrays are not null.
There are no duplicate numbers in each of the two arrays respectively.
Exmaples

A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
 */
public class CommonNumof2ArraysI {
    public List<Integer> common(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        if(a.length == 0 || b.length == 0){
           return null;
        }
        List<Integer> result = new ArrayList<>();
        int i = 0,j=0;
        while (i < a.length && j < b.length){
            if (a[i] < b[j]){
                i++;
            }else if(a[i] == b[j]){
                result.add(a[i]);
                i++;
                j++;
            }else {
                j++;
            }
        }
        return result;

    }
}
