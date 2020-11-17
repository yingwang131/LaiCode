package LinkedList;
import queueLinkedList.ListNode;
public class CheckLLisPalindrome {
    public boolean isPalindrome(ListNode head){
        //1find the middle，2 reverse 后面的那一段，3 2个指针，从左走到中间都一样return true；
        if (head == null || head.next == null){
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode two = reverse(middle.next);
        middle.next = null;
        while (head != null && two != null){
            if (head.value != two.value){
                return false;
            }
            head = head.next;
            two  = two.next;
        }
        return true;
    }
    private ListNode findMiddle(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        //base case
        if (head == null || head.next == null ){
            return head;
        }
        //sub problem
        ListNode newNode = reverse(head.next);
        // recursion rule
        head.next.next = head;
        head.next = null;

        return newNode;
    }
}
