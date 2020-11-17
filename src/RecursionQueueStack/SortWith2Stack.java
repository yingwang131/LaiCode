package RecursionQueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class SortWith2Stack {
    public void sort(LinkedList<Integer> s1) {
        // Write your solution here.
        if (s1 == null || s1.size() == 0){
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort2(s1,s2);
    }
    private void sort2(LinkedList<Integer> s1, LinkedList<Integer> s2){
        // sort in descending order and store result in the bottom part of input

        while (! s1.isEmpty()){
            // step1: push s1 to s2, check global min
            int gloMin = Integer.MAX_VALUE;
            int count = 0;
            while (! s1.isEmpty()){
                int cur = s1.pop();
                if (cur < gloMin){
                    gloMin = cur;
                    count = 1;
                } else if (cur == gloMin){
                    count++;
                }
                s2.push(cur);
            } // 1st while end: s1 == 0, 物理意义：把s1 push 到s2；并找出gloMin
            //step2:把s2 里面不是golMin的都放到s1；
            while (! s2.isEmpty() && s2.peek()>=gloMin){
                int temp = s2.pop();
                if (temp != gloMin){
                    s1.push(temp);
                }
                // else if (temp == gloMin){
                //   s2.pop();
                // }
            }// 2st while end: 物理意义：把比gloMin大的都放到s1，等于golMin的都丢掉
            //当执行完2st while，s1：有元素 s2：里面没有元素； 因为我们把比gloM大的都放到了s1，等于gloM的都丢掉了，所以s2现在是空的，当s2为空时，我们在把duplicate 的元素给放到s2 中即3rd while；

            // step3: 处理一下2个golMin，count = 2 的情况
            while (count > 0){
                s2.push(gloMin);
                count--;
            }// 3rd while end: 物理意义：把所有的duplicate 和golmin都存到了s2的最前面
            System.out.println(s2);

        }// 最大的这个while结束：s1是空的，所有元素都在s2

        //这个wile 只是按照题目来打印出它想要的，并在在给定的s1上表示出来：
        // After sorting the original stack should contain the sorted integers and
        // from top to bottom the integers are sorted in ascending order.
        while (!s2.isEmpty() ){
            s1.push(s2.pop());
        }
        System.out.println(s1);
    }

    public static void main(String[] args) {
        SortWith2Stack sol = new SortWith2Stack();
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(3);
        s1.push(3);
        s1.push(2);
        s1.push(4);
        s1.push(2);
        s1.push(4);
        sol.sort(s1);
    }
}
