package CrossTraing2;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class TowSumAllPairsI {
    /*
    注意：这个题目是求等于target的index pair
    A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

    A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
     */
    public List<List<Integer>> allPairs(int[] array, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //key: numbers; value:list of all possible indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        //为什么这里不用for（int num： array）呢？
        for (int i = 0; i < array.length; i++){
            List<Integer> index = map.get(target - array[i]);
            System.out.println(index);
            if (index != null){
                for (int j : index){
                    result.add(Arrays.asList(j,i));// asList?
                    System.out.println(result);
                }
            }
            if (!map.containsKey(array[i])){
                map.put(array[i], new ArrayList<Integer>());
                System.out.println(map);
            }
            List<Integer> temp =   map.get(array[i]);
            System.out.println(temp);
            temp.add(i);
            System.out.println(map);
        }
        return result;
    }

    /*
解题思路：
null
{1=[]}
[]
Map:{1=[0]}
——————————————
null
{1=[0], 3=[]}
[]
Map: {1=[0], 3=[1]}
————————————————————
[1]: map.get(3),return index = 1
[[1, 2]] ==[j (index=1) 实际的值是3, I(index=2)实际的值是= 2]
{1=[0], 2=[], 3=[1]}
[]
{1=[0],     2=[2],         3=[1]}  等号左边的是array[i]，等号右边的是index
    Index0    index2         index1
相当于 把数组扫了一遍，找出了每个元素对应的index number
-----------------------------------------------------
[0]
[[1, 2], [0, 3]]
{1=[0], 2=[2], 3=[1], 4=[]}
[]
{1=[0], 2=[2], 3=[1], 4=[3]}


[[1, 2], [0, 3]]

     */

    public static void main(String[] args) {
        TowSumAllPairsI sol = new TowSumAllPairsI();
        int[] array = {1,3,2,4};
        System.out.println(sol.allPairs(array, 5));
    }
}
