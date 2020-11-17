package DP2;

import java.util.Set;
/*
这是一个简单的2位dp，因为我用2个数组来存我的历史记录了；
用recursion也很简单
用dp 代码量更少
basecase:
    M[0][0] = 0;
	M[0][j] = j;
   	M[i][0] = i;     任何一个坐标为0的，都要考虑进去；
induction rule:
    if s1[i-1] == s2[i-1]   return M[i][j] = M[i-1][j-1]
    otherwise                         1+min(M[i-1][j-1], M[i-1][j], M[i][j-1])
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        //assume both string are not null
//        int len1 = one.length();
//        int len2 = two.length();
        int[][] distance = new int[one.length()+1][two.length()+1];
        for (int i = 0; i <= one.length(); i++){
            distance[i][0] = i;
        }
        for (int j = 0; j <= two.length(); j++){
            distance[0][j] = j;
        }
        for (int i = 1; i <= one.length(); i++){
            for (int j = 1; j <= two.length(); j++){
                if (one.charAt(i-1) == two.charAt(j-1)){
                    distance[i][j] = distance[i-1][j-1]; //do nothing;
                }else {
                    //replace, delete, insert
                    distance[i][j] = 1+min(distance[i-1][j-1],
                            distance[i-1][j],
                            distance[i][j-1]);

                }
            }
        }
        return distance[one.length()][two.length()];
    }
    private int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    public static void main(String[] args) {
        EditDistance sol = new EditDistance();
        String one = "sghj";
        String two = "asdf";
        System.out.println(sol.editDistance(one, two));
    }

}
