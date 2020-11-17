package String2;

import java.util.*;

/*
l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */
public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (lo.length() == 0){
            return result;
        }
        //when s is longer than 1, there is no way any of substring of 1 could be an 字谜
        if(sh.length() > lo.length()){
            return result;
        }
        //sh是待匹配的字符串 ab, lo是被匹配的字符串 abcbac
        Map<Character, Integer> map = coutMaps(sh);
        //优化后的算法，record how many distinct characters have been matched, only when all the distinct characters are matched
        //match == map.size(), we find the anagram
        int match = 0;
        //1: remove the leftmost character at the previous sliding window
        //2: add the right most character the the currnet sliding window
        for (int i = 0; i < lo.length(); i++){
            //add new char(right most) at the current sliding window
            char tmp = lo.charAt(i);
            Integer count = map.get(tmp); //count = 1;
            if (count != null){
                map.put(tmp, count -1);//这一步是在干什么，求出count，又减1？
                //字符tmp全部匹配完了
                if(map.get(tmp)==0){
                    match++;
                }
            }
            // handle the left most char at the previous sliding window
            if (i >= sh.length()){
                //窗口超过sh的长度，要把左边的字符补回去，如果该字符在sh中出现的话
                tmp = lo.charAt(i - sh.length());
                count = map.get(tmp);
                if (count != null){
                    map.put(tmp, count +1);
                    //sh中该字符被匹配的次数减少了一次，所以match-
                    if (count == 0){
                        match--;
                    }
                }
            }
            //count are all zero, if the current sliding window are matched
            if (match == map.size()){

                result.add(i - sh.length() + 1);
            }
        }
        return result;

    }
    private Map<Character, Integer> coutMaps(String sh){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char element: sh.toCharArray()){
            Integer count = map.get(element);
            if (count == null){
                map.put(element, 1);
            }else {
                map.put(element, count + 1);
            }
        }
        return map;
    }

    /*
    题目的意思是在s中寻找由p中字符任意组成的字符串的起始索引。我们可以先将p中的字符及其出现次数存入一个256大小的整型数组，然后使用循环，
    从s的第一位字符开始，如果从第1位到p的长度位的字符都能匹配，那么就将起始索引添加进list中。

第一，为了多次使用存有p字符及其出现次数的数组，我们使用Arrays.copyOf方法，每次复制出一个新数组来处理，不影响原数组中的值。

第二，如果当前字符作为起始无法匹配，那么就结束内层循环，进入s下一个字符继续开始。

第三，因为是连续判断p的长度位，所以外层循环的次数控制为s的长度减去p的长度，直接使用s的长度会报下标越界异常。
     */

    public List<Integer> findAnagrams2(String lo, String sh) {
        //输入：s：“cbaebabacd” p：“abc”
        //输出：[0,6]
        List<Integer> list = new ArrayList<Integer>();
        if (lo == null || lo.length() == 0 || lo.length() < sh.length()) {
            return list;
        }
        int[] shArr = new int[256];
        int[] loArr = new int[256];
        for(int i=0; i<sh.length(); i++){
            shArr[sh.charAt(i)]++;
            loArr[lo.charAt(i)]++;
        }
        if (Arrays.equals(shArr, loArr)) {
            list.add(0);
        }
        for (int j=sh.length(); j<lo.length(); j++) {
            ++loArr[lo.charAt(j)];
            --loArr[lo.charAt(j-sh.length())];
            if (Arrays.equals(shArr, loArr)) {
                list.add(j-sh.length()+1);
            }
        }
        return list;
    }


    /*
    题目的意思是在s中寻找由p中字符任意组成的字符串的起始索引。我们可以先将p中的字符及其出现次数存入一个256大小的整型数组，然后使用循环，从s的第一位字符开始，如果从第1位到p的长度位的字符都能匹配，那么就将起始索引添加进list中。

第一，为了多次使用存有p字符及其出现次数的数组，我们使用Arrays.copyOf方法，每次复制出一个新数组来处理，不影响原数组中的值。

第二，如果当前字符作为起始无法匹配，那么就结束内层循环，进入s下一个字符继续开始。

第三，因为是连续判断p的长度位，所以外层循环的次数控制为s的长度减去p的长度，直接使用s的长度会报下标越界异常。
     */

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return list;
        }
        int[] arr = new int[256];
        for (char ch : p.toCharArray()) {
            arr[ch]++;
        }
        int len = p.length();
        for (int i=0; i<=s.length()-len; i++) {
            boolean isMatch = true;
            int[] arr2 = Arrays.copyOf(arr, 256);
            for (int j=i; j<i+len; j++) {
                if (--arr2[s.charAt(j)] < 0) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        AllAnagrams sol = new AllAnagrams();
//        String sh = "ab";
//        String lo = "abcbac";

//        String lo = "abcbac";
//        String sh = "ab";


        String lo = "abcbac";
        String sh = "ab";

        System.out.println(sol.allAnagrams(sh,lo));
    }
}
