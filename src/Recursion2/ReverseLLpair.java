package Recursion2;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
  }
public class ReverseLLpair {
    public ListNode reversePair(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next =reversePair(head.next.next); //blue
        newHead.next = head;//red
        return newHead;
    }


}
