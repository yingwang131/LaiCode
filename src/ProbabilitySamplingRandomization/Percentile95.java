package ProbabilitySamplingRandomization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Percentile95 {
    public int percentile95(List<Integer> lengths) {
        // length is not null and size>=1
        // THE max length of url 4096
        // index代表数字，值为这个数字在lengths中出现的次数
        int[] count = new int[15];
//        for (int len : lengths) { //这里的for loop 取得是值，对于这个for each要理解
//            System.out.println(len);
//            System.out.println("*********");
//            System.out.println(count[len]);
//            count[len]++;
//
//        }
//        System.out.println(Arrays.toString(count));//[0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0]


       //每一个for each都可以改成一个 for loop，这个是正确的改法
        for (int i = 0; i < lengths.size(); i++) {
            int result = lengths.get(i);
            System.out.println(count[result]);
            count[result]++;

//            count[lengths.get(i)]++;
        }




//        for (int i = 0; i <= lengths.size(); i++){
//            count[i]++;//这种做法是错误的，因为for each取的是值，for 循环我是在和index玩
//        }
//        System.out.println(Arrays.toString(count));

        int sum = 0;
        int len = 15;
        while (sum <= 0.05 * lengths.size()) {
            len--;
            sum += count[len];
        }
        return len;
    }

    public static void main(String[] args) {
        Percentile95 sol = new Percentile95();
        List<Integer> lengths = new ArrayList<>();
        lengths.add(1);
        lengths.add(1);
        lengths.add(1);
        lengths.add(1);
        lengths.add(2);
        lengths.add(3);
        lengths.add(4);
        lengths.add(5);
        lengths.add(6);
        lengths.add(7);
        lengths.add(8);
        lengths.add(9);
        lengths.add(10);
        System.out.println(sol.percentile95(lengths));


    }
}
