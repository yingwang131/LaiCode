package RecursionQueueStack;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.LinkedList;

public class Sort2stackDebug {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        if (s1 == null || s1.size() == 0){
            return;
        }
        sort2(s1,s2);
    }
    private void sort2(LinkedList<Integer> s1, LinkedList<Integer>s2){
        while (!s1.isEmpty()) {
            int gloM = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                int cur = s1.pop();
                if (cur < gloM) {
                    gloM = cur;
                    count = 1;
                } else if (cur == gloM) {
                    count++;
                }
                s2.push(cur);
            }
            //把不是glom的给放到s1，glom可以丢掉，因为我知道谁是glom
            while (!s2.isEmpty() && s2.peek() >= gloM) {
                int temp = s2.pop();
                if (temp != gloM) {
                    s1.push(temp);
                }
            }
            //处理count 的gloM
            while (count > 0) {
                s2.push(gloM);
                count--;
            }
            System.out.println(s2);
        }
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }


    }
    public static void main(String[] args) {
        Sort2stackDebug sol = new Sort2stackDebug();
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
