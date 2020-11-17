package String2;

import java.util.Arrays;

///*
//“I love Google” → “Google love I”
//
//Corner Cases
//
//If the given string is null, we do not need to do anything.
// */
public class ReverseWordsInSentence1 {
    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, input.length() - 1); // reverse all
        // start to reverse each words
        int start = 0; //这里想先找到这个words的起点和终点，所以先把start设置成起点
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i; // 如果满足这个判断就是起点
            }
            // 从这里开始是判断是否满足终点的条件，如果满足，那么start 和 终点都知道了，就可以reverse了；注意这个for循环，如果终点条件不满足，i会一直++
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);// start起点，i终点
            }
        }
        return new String(array);
        //1 inverse all; 2 inverse each words
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }



    public static void main(String[] args) {
        ReverseWordsInSentence1 sol = new ReverseWordsInSentence1();
        String s = "I love google";
        char[] array = s.toCharArray();
        System.out.println(sol.reverseWords(s));
        System.out.println(new String(array));
    }
}
