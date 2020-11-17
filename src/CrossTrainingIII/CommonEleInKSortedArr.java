package CrossTrainingIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.
 */
public class CommonEleInKSortedArr {
    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input){
        //K-way Merge 时间复杂度太高，还不如用iterative 和Binary reduction 的方法,这个题目用的是Binary induction，因为把前一轮上端结果，有返回给了result；
        List<Integer> result = input.get(0); // get 方法get 的是index
        for (int i = 1; i < input.size(); i++){
            result = helper(result, input.get(i));
        }
        return result;
    }
    public List<Integer> helper(List<Integer>a, List<Integer> b){
        List<Integer> res = new ArrayList<>();
        int i =0, j = 0;
        while(i < a.size() && j < b.size()){
            int compare = a.get(i).compareTo(b.get(j));
            if (compare == 0){
                res.add(a.get(i));
                i++;
                j++;
            }else if (compare < 0){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CommonEleInKSortedArr sol = new CommonEleInKSortedArr();
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(Arrays.asList(1, 2, 2, 3));
        input.add(Arrays.asList(2, 2, 3, 5));
        input.add(Arrays.asList(2, 2, 4));
        System.out.println(sol.commonElementsInKSortedArrays(input));
    }
}
