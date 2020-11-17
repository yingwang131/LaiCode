package OA;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class MapSet {
    public static int nonDuplicates(int[] array){
        Map<Integer, Integer> count = new HashMap<>();
        for (int a: array){
            Integer aNum = count.get(a);
            if (aNum == null){
                aNum = 1;
            }else {
                aNum++;
            }
            count.put(a, aNum);
        }

        Set<Integer> keySet = new HashSet<>(count.keySet());
//        System.out.println(count.keySet());
        for (Integer key: keySet){
            //k,v
            //key=2, value=4
            //key=3
            //key=2, value=3
            if (count.get(key) != null && count.get(key) > 1){
//                System.out.println(count.get(key));
                count.remove(key);
            }
            //我感觉是如果 在一个for loop里面包裹着一个 while 循环或者if 循环都是可以的，只要一直满足for，if和while都会执行；
        }
        return count.size();
    }


    public static void main(String[] args) {
        int[] array = {3,3,2,6,7,7};
        System.out.println(nonDuplicates(array));
//        for (int x: array){
//            while (array.length != 0 && x > 5){
//                System.out.println(x);
//            }
//        }
    }
}
