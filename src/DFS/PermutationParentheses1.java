package DFS;

import java.util.ArrayList;
import java.util.List;

/*
N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
一共有6层，每一层代表半个括号
每一层有2个孩子，代表加左半个，还是加右半个
 */
public class PermutationParentheses1 {
    public List<String> validParentheses(int n){
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (n == 0){
            return result;
        }
        helper(result, sb, 0,0, n);
        return result;
    }
    private void helper(List<String> result, StringBuilder sb, int left, int right, int n){
        //basecase:到第6层应该都做完了，打印出来
        if (left + right == 2 * n){
            result.add(sb.toString());
            return;
        }
        //recursion rule
        //a：什么时候放左括号，n < 3 时：（（（
        if (left < n){
            sb.append('(');
            helper(result, sb, left + 1, right, n);
            // 把这两行放在if外面为什么会outofbound，因为放在if外面的话，当n = 2，即2 < 2 时，不加（，但要是helper在if外面，会继续执行下面的helper
            // 如果helper在if里面的话，当n=2，即2<2时，就会向下去执行 left > right了，所以放在外面是错误的；会打印出一些不符合的结果
            sb.deleteCharAt(sb.length() - 1);
        }






        //B：什么时候放右括号，1：右括号 <= 左括号，即： 左括号 > 括号；所以说经加上的左括号的数量一定要严格的 > 右括号的数量，否则没有资格配对,所以必须写
        // left 》right 才有资格，才会输出正确结果
        // 有些右括号不能加，要剪枝
        if (left > right){
            sb.append(')');
            helper(result,sb, left, right + 1,n);
            sb.deleteCharAt(sb.length() - 1);
        }


    }

    public static void main(String[] args) {
        PermutationParentheses1 sol = new PermutationParentheses1();
        int n = 3;
        System.out.println(sol.validParentheses(n));
    }
}
