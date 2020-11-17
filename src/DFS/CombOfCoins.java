package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)

]
total value = 99 cents;
coin value(面值)：25 10 5 1 cent
打印出所有的排列组合之和是99
1：一共可以分成4层，每一层代表不同的面值
2：每一个node可以分动态的node，因为面值的不同，越小的面值，组合数越多，eg1 有99种，99个node

依然是一个recursion,但是一个多叉多，不是二叉树
basecase：
recursion rule：
 */
public class CombOfCoins {
    public List<List<Integer>> combinations(int target, int[]coins){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0 ){
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        helper(target, coins, cur, 0, result);
        return result;
    }
    private void helper(int moneyLeft, int[]coins, List<Integer>cur,  int index_level, List<List<Integer>> result){
        //basecase
        if (index_level == coins.length){
            if (moneyLeft == 0){
                result.add(cur);
            }
            return;
        }

        /*
        if (index_level == coins.length - 1){
            if (moneyLeft % coins[index_level] == 0){
                cur.add(moneyLeft/coins[index_level]);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size()-1 );
            }
            return;
        }

         */



//        //recursion rule: i 的物理意义是 coin[index] 用了多少次；
        for (int i = 0; i <= moneyLeft / coins[index_level]; i++){
            cur.add(i);
            helper(moneyLeft - i * coins[index_level],coins, cur, index_level+1, result);
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombOfCoins sol = new CombOfCoins();
        int[] coin = {25,10,5,1};
//        int[] coin = {2,1};
        System.out.println(sol.combinations(99, coin));
    }
}
