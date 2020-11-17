package Recursion2;
/*
input “sophisticated” since “11” matches eleven chars “ophisticate”.   st u dent
pattern “s11d” matches                                                  2
true

 “s         ophisticated”
  txtstart
  s         11d
  patternStart
case1: patter[0] is a letter, if pattern[0] == text[0],recursive to match patterm[1],test[1]
case2: patter[0] is a number, read out contigous digits to form a number(18),then recursive all text[num] pattern[num.length]
 */

public class StringAbbreMatch {
    public boolean match(String input, String pattern) {
        return matchHelper(input, pattern, 0, 0);
    }
    private boolean matchHelper(String text, String pattern, int textStart, int pattStart){
        //basecase
        if (textStart == text.length() &&   pattStart == pattern.length()){
            return true;
        }else if (textStart >= text.length() || pattStart >= pattern.length()){
            return false; //为什么去掉=， laicode过不去？
        }
        //recursive rule
        // case1:pattern[0] is a letter; 如果 pattern 是一个letter ，就看他们是不是一样，不一样的letter return false；
        //先把text的第一位取出来
        if (pattern.charAt(pattStart) < '0' || pattern.charAt(pattStart) > '9'){ //一个判断条件，首先要判断patterstart <0,>9那它一定是个字母，不是数字，
            // 首先check patter[0]一定是字母，不是数字。所有的patter【0】是字母的都来这里；这个大的if，就很好的过滤掉，patter[0]是数字的情况，因为是数字的话，
            //一定有一个 ascii是满足 0 到 9的值；
            // 然后再判断patter【0】和text[0]2个字母是否相等；相等就各自++；做recursion；
            if (text.charAt(textStart) == pattern.charAt(pattStart)) {
                return matchHelper(text, pattern, textStart + 1,pattStart + 1);
            }
            return false;

        }
        // case2：pattern[0] is a digit
        // need to find in total whit is the number; 123 means 123
        int count = 0;
        //当patter【0】 是数字的时候，我们总是check patter【0】来确认， 要用case2；
        //当patter[0]是数字，ps<plength 并且 ps >= 0 并且 ps <= 9,这3个条件绝对保证是数字

        while (pattStart < pattern.length() && pattern.charAt(pattStart) >= '0' && pattern.charAt(pattStart) <= '9'){
            count = count*10 + (pattern.charAt(pattStart) - '0');
            pattStart++;
        }
        return matchHelper(text,pattern, textStart+count, pattStart);
    }

    public static void main(String[] args) {
        StringAbbreMatch sol = new StringAbbreMatch();
//        String input = "student";
//        String pattern = "s2d2t";
        String input = "sophisticated";
        String pattern = "s11d";
        System.out.println(sol.match(input, pattern));
    }
}
