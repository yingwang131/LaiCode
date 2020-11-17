package queueLinkedList;

public class ListNode {
        public int value;
        public ListNode prev;
        public ListNode next;
        public ListNode(int value){
            this.value = value;
            next = null;

        }
        public int getValue(){
            return value;
        }
        public ListNode getNext(){
            return next;
        }


    }

