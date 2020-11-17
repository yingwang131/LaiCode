package queueLinkedList;


public class GenerateLinkedList {

    public ListNode generate(int n){

        ListNode head  = new ListNode(1);
        ListNode cur = head;
        for (int i = 1; i < n; i++){
//            if (head.next == null){
//                return null;
//            }
            cur.next = new ListNode(i);
            cur = cur.next;

        }
        return head;
    }

    public static void main(String[] args) {
        GenerateLinkedList sol = new GenerateLinkedList();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        int n = 4;
        sol.generate(n);
        while (head != null){
            System.out.println(head.getValue() + " ");
            head = head.getNext();
        }

    }

}
