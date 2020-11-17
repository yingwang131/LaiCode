package OA;

import java.util.Arrays;

public class PassByValue {
    public static void f (int[] z, int y){
        for (int i =0; i < z.length; i++){
            z[i] += y;
        }
        y *= 2;
        System.out.println(Arrays.toString(z) + ',');
    }

    public static void main(String[] args){
        int[] x = {5,6,7};
        int y = 4;
        System.out.println(Arrays.toString(x));
        f(x, y);
        System.out.println(Arrays.toString(x)+ ',' + y );
    }
}
