package HashTableStringI;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

/*
A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */
public class CommonNumOfSortedArray {
    //方法1，和missingNum那个题很像，也可以用hashSet，但是用了hashSet的话，这个sorted array的性质就完全没有用到，并且时间复杂度也高
    //step1: insert all numbers in A into HashSet
    //step2: for each element in B check if its in the hashSet
    // 方法1 有点问题，还没有修复，用hashSet不能做到这个题，因为有重复元素.并且A 和B的关系是未知的，最好用HashMap，Math.min可以取出想要的
    public List<Integer> common(int[] A, int[] B){
        List<Integer> result = new ArrayList<>();
        List<Integer> deDup = new ArrayList<>();
        HashSet<Integer> mySet = new HashSet<>();

        for(int x: A){
            mySet.add(x);
        }

//        int[] A = {1,2,3,4,5,6};
//        int[] B = {1,3,3,3};
//        结果：【1，3】 不是 【1，3，3】如果在A B里面都出现过一次，result也只打印一次

//        int[] A = {1,1,2,4,4,6,6,6};
//        int[] B = {1,3,5,5,6,6};
//        结果：【1，6，6】 不是 【1，6】如果在A B 同时出现过2次，result 就打印2次
        for (int y: B){
            if (mySet.contains(y)){
                result.add(y);
            }
        }
        //result [1,3,3,3]
//        for (int i=0; i<result.size(); i++) {
//            if(!deDup.contains(result.get(i))) {
//                deDup.add(result.get(i));
//            }
//        }

//        return deDup;
        return result;
    }

    //方法2，快慢指针，谁小移动谁，如果一样的话，就加到output里面
    public List<Integer> common2(int[] A, int[] B){
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length ){
            if (B[j] < A[i]){
                j++;
            }else if (B[j] == A[i]){
                res.add(A[i]);
                j++;
                i++;
            } else {
                i++;
            }
        }
        return res;
    }
    //方法3：hashMap也可以，见答案漏
    public List<Integer> common3(int[] A, int[] B) {
        // Write your solution here
        // Use HashMap
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map =new HashMap<>();
        //1put all the A element into to map, count as key value pair

        for (int x: A){
            Integer freq = map.get(x);
            if (freq == null){
                map.put(x,1);
            }else{
                map.put(x, freq+1);
            }
        }


        Map<Integer, Integer> mapB = new HashMap<>();
        for (int y: B){
            Integer freq = mapB.get(y);
            if (freq == null){
                mapB.put(y,1);
            }else{
                mapB.put(y, freq+1);
            }
        }

        //3 compare mapA and mapB, return common element
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            Integer resKey = entry.getKey();
            Integer countB = mapB.get(resKey);
            //Integer countB = mapB.get(entry.getKey());
            if (countB != null){
                int appear = Math.min(entry.getValue(), countB);
                for (int i = 0; i < appear; i++){
                    list.add(entry.getKey());
                }
            }
            Collections.sort(list);

        }
        return list;


    }

    public static void main(String[] args) {
        CommonNumOfSortedArray sol = new CommonNumOfSortedArray();
//        int[] A = {1,2,1,4,5,6};
//        int[] B = {1,3,3,3};

        int[] A = {4, 4, 5, 5, 7, 10, 10, 10, 13, 13, 15, 15, 16, 20, 22, 22, 24, 24, 25, 26, 26};
        int[] B = {0, 2, 2, 3, 5, 6, 9, 9, 9, 10, 12, 12, 13, 14, 14, 15, 17, 19, 19, 23, 25};
//        System.out.println(sol.common3(A,B));

        /*
        int[] arr = {10,33,5,7};
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
         */
        char x = 'A';
        System.out.println((int) x);
        System.out.println((char) 48);

    }

}
