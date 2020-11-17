package DP1;

import java.util.HashSet;
import java.util.Set;

/*
basecase M[1] = check dict for the first char
Induction rule:
 */
public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict){
        Set<String> set = helperSet(dict);
        boolean[]M = new boolean[input.length() + 1]; //创建一个记事本，左大段需要看前面记录的历史，所以需要多一位
        for (int i = 1; i < M.length ; i++){
            //case 0: bob is in the dict 就是一刀也不切, done
            if (set.contains(input.substring(0,i))){
                M[i] = true;
            }
            //otherwise: 需要切刀，就是要左大段，右小段的方法
            // 第二个for 循环就是关于这一刀到底切在哪里
            for(int j = 1; j < i; j++){
                if (M[j] && set.contains(input.substring(j,i))){
                    M[i] = true;
                    break;
                }
            }
        }
        return M[input.length()];

    }
    private Set<String> helperSet(String[] dict){
        Set<String> set = new HashSet<>();
        for (String s: dict){
            set.add(s);
        }
        return set;
    }

    public static void main(String[] args) {
        DictionaryWordI sol = new DictionaryWordI();
        String input = "bobcatrob";
        String[] dict = {"bob","cat","rob"};
        System.out.println(sol.canBreak(input, dict));
    }
}
