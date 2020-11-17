package HashTableStringI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
"abbbaaccz" → "aaaccz" → "ccz" → "z"  -->这种是连续的字母 一个都不保留，直到剩下没有重复过的
"aabccdc" → "bccdc" → "bdc"
 */
public class RemoveAdjRepeatedChar {
    public String deDup(String input){
        char[] array = input.toCharArray();
        if (input.isEmpty()){
            return input;
        }
        Deque<Character> myStack = new ArrayDeque<>();
        int j = 0;
        while (j < array.length){
            char curChar = array[j];
            if (!myStack.isEmpty() && myStack.peekFirst()==array[j]){//?
                while (j < array.length && array[j] == curChar){
                    //？ array[j] == array[j]，这么写肯定不对，因为会一直j++，因为不管array【j】等于多少，它都会和自己相等
                    // 我命名一个临时的 char 的记录器，去记录现在j的index上面的b，如果array[j] 等于了刚才零时记录的char 记录器，那我继续j++，
                    // 当 j index走到a的时候，char cur记录器就变成了 a，再拿array[j]和刚才的记录器比较，如果相等继续j++
                    j++;
                }
                myStack.pollFirst();
            }else {
                myStack.offerFirst(array[j]);//why not array[j]
                j++;
            }
        }
        int len = myStack.size();
        for (int i = len - 1; i>=0; i--){
            array[i] = myStack.pollFirst();
            //这里相当于把stack 里剩下的元素 给倒了出来，因为stack里面是：YWZ,但我们要的是zwy，
            // 最后到return new string（array, 0, len）的时候 是 zwybbaaazw, 但我要的是从0到3但不包含3的字符串；也就是为什么返回newString（array，0，到len了）
        }
        return new String(array, 0 , len);
    }

    //第二个做法，是为了测试，只有一个input， 和 两个相同的input的，一定要有条件：stack不能为空，当差相同的时候，指针不能出界
    public String deDup2(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int x = 0;
        while (x < array.length){
            char curChar = array[x];
            if (!stack.isEmpty() && array[x] == stack.peekFirst()){
                while (x < array.length && array[x] == curChar){
                    x++;
                }
                stack.pollFirst();

            }else {
                stack.offerFirst(array[x]);
                x++;
            }
        }
        int len = stack.size();
        for (int i = len - 1; i>=0; i--){
            array[i] = stack.pollFirst();
            System.out.println(array[i]);
        }
        return new String(array, 0, len);

    }

    public static void main(String[] args) {
        RemoveAdjRepeatedChar sol = new RemoveAdjRepeatedChar();
        String input = "abbbbaaazwy";
        String input2 = "a";
        String input3 = "aa";
        String input4 = "1223311";
        System.out.println(sol.deDup(input));
    }
}
