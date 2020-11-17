package CrossTraing2;

import CrossTraing2.DeepCopyLLwithRandomPointer.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLLwithRandomPointer {
    static class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int value) {
            this.value = value;
        }

        public String toString() {
            return Integer.toString(value);
        }
    }

    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> lookup = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        lookup.put(head, newHead);
        RandomListNode curr = newHead;
        while (head != null) {
            if (head.next != null) {
                if (!lookup.containsKey(head.next)) {
                    lookup.put(head.next, new RandomListNode(head.next.value));
                }
                curr.next = lookup.get(head.next);
            }
            if (head.random != null) {
                if (!lookup.containsKey(head.random)) {
                    lookup.put(head.random, new RandomListNode(head.random.value));
                }
                curr.random = lookup.get(head.random);
            }
            head = head.next;
            curr = curr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        DeepCopyLLwithRandomPointer sol = new DeepCopyLLwithRandomPointer();

        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        RandomListNode node4 = new RandomListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = node2;
//        System.out.println(sol.copy(head).toString());
        //根据sout这句话也可以debug这个代码的过程
        //如果我要想打印我需要customered打印出来的样子，觉得麻烦就没做
        System.out.println("--------next----");
        while (head != null) {
            System.out.print(head.value);

            if (head.random != null) {
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("\\/");
                System.out.println(head.random.value);
            }
            head = head.next;
        }
        System.out.println();

    }
}
