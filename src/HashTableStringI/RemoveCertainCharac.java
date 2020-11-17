package HashTableStringI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
总结：2个挡板，3个区域，同向而行；
case1：a[j] should be kept, a[i] = a[j], i++,  j++;
case 2:  a[j] should not be kept, j++;
Termination condition: j >= n
Return：a[0, i - 1]

 */
public class RemoveCertainCharac {
    public String remove(String input, String t){
        //input 是一个字符串，我要把字符串转化为数组
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        int i = 0, j = 0;
//        for (int j = 0; j < array.length; j++){
//            if (!set.contains(array[j])){
//                array[i] = array[j];
//                i++;
//            }
//        }
        while (j < array.length){
            if (!set.contains(array[j])){
                array[i] = array[j];
                i++;
                j++;

            } else{
                j++;
            }

        }
        return new String(array,0,i);
    }

    //写一个set就是为了比较方便的拿到要删除的元素，比如说我要删除5个char，难道if（1&&2&&3&&4&&5）么？
    //题目给的 input："un" 是连在一起的一个string，如果我不把它们放在set里面，直接比较的话，可能怎么也找不到；
    private Set<Character> buildSet(String t){
        //做个for循环把多个要删除的元素即t，都存到set里面；
        Set<Character> mySet = new HashSet<>();
        for (int i = 0; i < t.length(); i++){
            mySet.add(t.charAt(i));
            System.out.println(t.charAt(i));
        }
// 要想用foreach遍历，要被遍历的对象，可以是数组，集合，int[]A = {1,2,3}，String[]a = {"A","B","C"},不能是个String呀
//        for ( x: t){
//            mySet.add(t);
//        }
        return mySet;

    }

    public static void main(String[] args) {
        RemoveCertainCharac sol = new RemoveCertainCharac();
//        String result = sol.remove("student","un");
        String result = sol.remove("aaaaaabbbbbccdddd","abc");
        System.out.println(result);

        String a = "dan";
        System.out.println(a.charAt(1));
        System.out.println(Arrays.toString(new char[0]));
        System.out.println(Arrays.toString(new String[0]));
        System.out.println(a.toCharArray());
        System.out.println(a.length());
        int[] array = {3,5,6};
        System.out.println(array.length);
        // 数组有length属性，没有length方法，因为数组的父类从Object继承过来的属性，是类的属性，不需要加括号
        // String 是一个类，length()是String 类的一个方法，故可以直接调用length()方法来返回该字符串的长度

    }
}
