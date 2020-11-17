package CrossTrainingIII;

import java.util.*;

/*
Assumptions

Both of the two arrays are not null.
In any of the two arrays, there could be duplicate numbers.
Examples

A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
 //use hashMap 因为里面有重复的；
 1 想把A里面的数字放到map里面：1->1;2->2;3->1
 2: 想把B里面的数字放到map里面：3->1;4->1;2->3
 */
public class CommonNumof2ArraysII {

    public List<Integer> common(int[] A, int[] B){
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for ( int  x : A){
            Integer times = mapA.get(x);
            if (times == null){
                mapA.put(x, 1);
            }else{
                mapA.put(x, times+1);
            }
        }
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for ( int  x : B){
            Integer times = mapB.get(x);
            if (times == null){
                mapB.put(x, 1);
            }else{
                mapB.put(x, times+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()){
            Integer ctInB = mapB.get(entry.getKey());
            if (ctInB != null){
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < appear; i++){
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonNumof2ArraysII sol = new CommonNumof2ArraysII();
        int[] A = {11,21,11,22,11,3,14,4,0,14,19,8,11,22,21,23,4,21,10,23,22};
        int[] B = {20,1,24,9,23,22,23,11,13,0,12,4,19,25,17,26,4,15,16,6,4};
        System.out.println(sol.common(A,B));

    }
}
