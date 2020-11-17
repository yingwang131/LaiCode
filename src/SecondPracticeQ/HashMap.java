package SecondPracticeQ;

import java.util.Arrays;

/*
1:api
2:fields
3:constructor
4:implementation
 */
public class HashMap<k,v> {
    public static class Node<k,v>{
        private final k key;
        public v value;
        public Node<k,v> next;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }

        public k getKey(){
            return this.key;
        }
        public v setValue(v value){
            return this.value = value;
        }
        public v getValue(){
            return this.value;
        }

    }

    //fields
    private int size;
    private Node<k,v> buckets[];
    private static final double LOAD_FACTOR_LIMIT = 0.75;
    private static final int DEFAULT_CAPACITY = 11;
    private static final int SCALE_FACTOR = 2;

    //constructor
    public HashMap(){
        buckets = new Node[DEFAULT_CAPACITY];
    }

    public int size(){
        return this.size;

    }
    public boolean isEmpty(){
        return size == 0;

    }
    public v put(k key, v value){
        int idx = getIndex(key);
        Node<k,v> head = buckets[idx];
        while (head != null){
            if (equalsKey(head.getKey(), key)){
                v oldValue = head.getValue();
                head.setValue(value);
                return oldValue;
            }
            head = head.next;
        }
        Node<k,v> newNode = new Node<>(key, value);
        newNode.next = buckets[idx];
        buckets[idx] = newNode;
        size++;
        if (((double) size) / buckets.length >= LOAD_FACTOR_LIMIT){
            rehashing();
        }
        return null;

    }
    public void rehashing(){

    }

    public int getIndex(k key){
        if (key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % buckets.length);
    }
    public boolean equalsKey(k one, k two){
        if (one == null && two == null){
            return true;
        }
        if (one == null || two == null){
            return false;
        }
        return one.equals(two);
    }
    public v get(k key){
        int idx = getIndex(key);
        Node<k,v> head = buckets[idx];
        while (head != null){
            if (equalsKey(head.getKey(), key)){
                v oldValue = head.getValue();
                return oldValue;
            } else {
                head = head.next;
            }
        }
        return null;
    }
    public v remove(k key){
        int idx = getIndex(key);
        Node<k,v> head = buckets[idx];
        while (head != null){
            Node<k,v> dummy = new Node<>(null, null);
            Node<k,v> prev = dummy;
            dummy.next = head;
            if (equalsKey(head.getKey(), key)){
                v oldValue = head.getValue();
                prev.next = head.next;
                size--;
                buckets[idx] = dummy.next;
                return oldValue;
            }
            prev = head;
            head = head.next;

        }
        return null;
    }
    public boolean containsKey(k key){
        int idx = getIndex(key);
        Node<k,v> head = buckets[idx];
        while (head != null){
            if (equalsKey(head.getKey(), key)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public void clear(){
        Arrays.fill(buckets, null);
        this.size = 0;

    }
//    public String toString(){
//
//    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(map.put("ying",1));
        System.out.println(map.put("ying",2));
        System.out.println(map.containsKey("ying"));
        System.out.println(map.get("ying"));
        System.out.println(map.remove("ying"));
//        System.out.println(map.size());
    }
}

