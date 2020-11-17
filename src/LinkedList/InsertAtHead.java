//package LinkedList;
//
//public class MyLinkedList {
//    //内部类
//    class Node {
//        private int data;
//        private Node next;
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    private Node head;
//
//    public MyLinkedList() {
//        this.head = null;
//    }
//
//    //头插法
//    public void addFirst(int data) {
//        Node node = new Node(data);
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            node.next = this.head;
//            this.head = node;
//        }
//    }
//
//    public class TestLinkedList {
//        public static void main(String[] args) {
//            MyLinkedList myLinkedList = new MyLinkedList();
//            myLinkedList.addFirst(1);
//            myLinkedList.addFirst(2);
//            myLinkedList.addFirst(3);
//            myLinkedList.addFirst(4);
//            myLinkedList.display();
//
//
//        }
//    }
//}
//
