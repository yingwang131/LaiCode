package String2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatChar {
    public int longest(String input) {
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()){
            if (set.contains(input.charAt(fast))){
                set.remove(input.charAt(slow));
                slow++;
            }else{
                set.add(input.charAt(fast));
                fast++;
                longest = Math.max(longest, fast-slow);
            }
            System.out.println(set);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatChar sol = new LongestSubstringWithoutRepeatChar();
        String input = "BDEFGADE";
        System.out.println(sol.longest(input));
    }
}
