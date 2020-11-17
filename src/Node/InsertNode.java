package Node;

/*
1 -> 3 -> null, insert : 2 → return 1 -> 2 -> 3 -> null
 */

//import queueLinkedList.ListNode;


class ListNode {
    public int value;
    public ListNode prev;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;

    }

    public int getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }
}
    public class InsertNode {
        public static ListNode insertNode(ListNode head, int target) {
            // 分2种情况，1：加入0 的时候； 2：加入7 和14的时候；
            ListNode newNode = new ListNode(target);
            // the frist case: insert the 0 at the beginning
            if (head == null || head.value >= target) {
                newNode.next = head;
                return newNode;
            }

            // the second case: insert 7, 14
            ListNode prev = null;
            ListNode cur = head;

            //这里有2个判断条件，第一个是 cur == null 的时候，即在尾端insert时执行
            // p.next = newNode, newNode.next = cur;
            // 第二种是 cur >= target 时；执行p.next = newNode, newNode.next = cur;
            while (cur != null && cur.value <= target) {
                prev = cur;
                cur = cur.next;
            }

            prev.next = newNode;
            newNode.next = cur;
            return head;

        }

        public static void main(String[] args) {
            ListNode head = new ListNode(2);
            ListNode node1 = new ListNode(3);
            ListNode node2 = new ListNode(6);
            ListNode node3 = new ListNode(9);
            ListNode node4 = new ListNode(13);
            head.next = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;

            ListNode res = insertNode(head, 14);
            while (res != null) {
                System.out.println(res.getValue() + " ");

                res = res.getNext();
            }
        }


}