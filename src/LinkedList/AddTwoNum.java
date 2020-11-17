package LinkedList;
import queueLinkedList.ListNode;
public class AddTwoNum {
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int val = 0;
        while (l1 != null || l2 !=null || val!= 0){
            if (l1 != null){
                val += l1.value;
                l1 = l1.next;
            }
            if (l2 != null){
                val += l2.value;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            val = val/10;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode heads = new ListNode(6);
        ListNode nodes1 = new ListNode(3);
        ListNode nodes2 = new ListNode(6);
        ListNode nodes3 = new ListNode(2);
        heads.next = nodes1;
        nodes1.next = nodes2;
        nodes2.next = nodes3;
        ListNode res = addTwoNumbers(head, heads);
        while (res != null){
            System.out.println(res.getValue() + " ");
            res = res.getNext();
        }
    }
}
