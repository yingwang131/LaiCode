package CrossTraing2;

public class ReverseLLIneratiive {

    class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
  }
    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
