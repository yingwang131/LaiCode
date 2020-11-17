package String2;

import java.util.ArrayList;

/*
input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "laicode", S = "code", T = "offer", input becomes "laioffer"

case 1: s1.length >= s2.length. In this case, eg den-->XX, it is easy

 */
public class StringReplaceBasic {
    public String replace(String input, String source, String target){
        char[] array = input.toCharArray();
        if(source.length() >= target.length()){
            return replaceShorter(array, source, target);
        }
        return replaceLonger(array, source, target);
    }

    private String replaceShorter(char[]array, String source, String target){
        int slow = 0, fast = 0;
        //不写if 里面的fast<arrL-sourL会发生什么？测试了多次，结果很长不好debug，感觉还是对这个f指针位置的物理意义不理解
        // fast < array.length-target.length() 不对；
        // fast < array.length-source.length()不对； 之间把这个条件删除也不对；
        // 只有fast <= array.length-source.length()才对；

        while (fast <  array.length){
            if ( fast <= array.length-source.length() &&  equalSubstring(array, fast,source)){
                copySubstring(array, slow, target);
                slow += target.length();// slow 直接跳过 需要替换元素的个数 的步数：slow + 2， 即到n这个letter
                fast += source.length();// fast 直接跳过 pattern（den）的步数， fast=3, 3+3=6,即到t这个letter；
            }else{
                array[slow++] = array[fast++];

                // 剩下的这个，对不上pattern的就copy，并s++，f++；但是不copy也一样都是原来的字母；
            }
        }
        return new String(array, 0, slow);
    }

    // s t u  d e n t w d e n t    den  → XXXX, 需要考虑扩容,matches[5,10], 5是第一个den 结尾n的index，10是第二个den结尾的n的index
    // s t u  x x x x t w x x x x t
    // step1：计算有多少个patter在当前的input里, input.length() =12
    // step2：需要预留出几个位置，如果input里面发现了2个pattern，size的大小： 2*（4-3）=2, 所以需要extend 2个位置, 所以总位置：inputlength+2*（4-3）=14
    // step3: 确认 fast和slow的位置，从后往前跑
    private String replaceLonger(char[]array, String source, String target){
        // get all the matches end positions in the input char array of string source
        ArrayList<Integer> matches = getAllMatches(array, source);
        char[] result = new char[array.length + matches.size()* (target.length() - source.length())];
        int fast = array.length -1;
        int slow = result.length -1;
        int lastIndex = matches.size() - 1;//  check den，从后往前check，所以最后一位是match.Size-1；matches[5,10]

        while (fast >= 0){
            //在这里我需要拿到matches 的最后一个元素，所以才产生了lastIndex 变量，并且它随着matches 最右一个元素的位置变化而--
            if (lastIndex >= 0 && fast == matches.get(lastIndex)){
               //因为是从后往前找，所以找ned，matches.get（10）= n，如果fast == n说明发现pattern的最后一个字母了
                // 这里不是在说slow 指针；
                copySubstring(result, slow - target.length() + 1, target);
                slow -= target.length();// slow 指针，向左移动 需要替换元素的个数 的步数， slow -= 4
                fast -= source.length();// fast 向左移动 pattern（den）的步数， 即3；
                lastIndex--; // lastIndex = 0?
            }else {
                result[slow--] = array[fast--];
            }
        }
        return new String(result);
     }
     private ArrayList<Integer> getAllMatches(char[] array, String source){
         ArrayList<Integer> matches = new ArrayList<>();
         int i = 0;
         while (i <= array.length - source.length()){ // while的判断为什么会这么写？为了减少几行代码，不用所有的都检查
             if (equalSubstring(array, i, source)){
                 matches.add(i + source.length() -1);
                 i+= source.length();
             }else {
                 i++;
             }
         }
         return matches;
     }

    // check if the substring from fromIndex is the same as s,pattern
    private boolean equalSubstring(char[] input, int fastIndex, String source){//fromIndex 指fast
        for (int i = 0; i < source.length(); i++){
            if (input[fastIndex + i] != source.charAt(i)){
                return false;
            }
        }
        return true;
    }

    // copy the string t to result at fromIndex
    private void copySubstring(char[] result, int slowIndex, String target){
        for (int i = 0; i < target.length(); i++){
            result[slowIndex + i] = target.charAt(i);
        }
    }



    public static void main(String[] args) {
        StringReplaceBasic sol = new StringReplaceBasic();
//        String input = "student";
//        String source = "den";
//        String target = "xx";

        String input = "studentwdent";
        String source = "den";
        String target = "xxxx";

//        String input = "njdsdrhooknfffgelevmahooknfffgthooknfffghooknfffghooknfffgehooknfffgljlgmqqhooknfffgvbvlh";
//        String source = "hooknfffg";
//        String target = "uddw";

//        String input = " ";
//        String source = "b";
//        String target = "d";
        System.out.println(sol.replace(input,source,target));
        System.out.println(input.length());
    }

}
