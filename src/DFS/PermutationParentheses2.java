package DFS;

import java.util.ArrayList;
import java.util.List;

public class PermutationParentheses2 {

    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> list = new ArrayList<>();
        if (list == null){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        helper(list, sb, n, 0, 0);
        return list;
    }
    public void helper(List<String>list, StringBuilder sb, int n, int leftB, int rightB){
        if ( leftB + rightB == 2*n ){
            list.add(sb.toString());
            return;
        }


        if (leftB < n){
            sb.append("(");
            helper(list,sb, n, leftB+1, rightB );
            sb.deleteCharAt(sb.length() -1 );
        }

        if (rightB < leftB){
            sb.append(")");
            helper(list,sb, n, leftB, rightB+1 );
            sb.deleteCharAt(sb.length() -1 );
        }
    }
}
