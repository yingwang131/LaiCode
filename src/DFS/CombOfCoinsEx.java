package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombOfCoinsEx {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        if (target == 0){
            return list;
        }
        helper(target, coins, list, cur, 0);
        return list;
    }
    public void helper(int target,int[] coins,List<List<Integer>> list,List<Integer> cur, int index){
        if (index == coins.length){
            if (target == 0){
                list.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = 0; i <= target/coins[index]; i++){
            cur.add(i);
            helper(target-i*coins[index], coins, list, cur, index+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        CombOfCoinsEx sol = new CombOfCoinsEx();

        int[]coin = {25,10,5,1};
        int[]so = {};
        sol.combinations(99,coin );
    }
}
