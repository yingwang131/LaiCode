package HashTableStringI;

import java.util.Arrays;

/*
1:class structure, API
2:Data:fields
3:Constructor: capacity, load Factor,
4:Implementation
 */
public class HashMapPlay<K, V> {
   public static class Node<K, V>{
        private final K key;
        private V value;
        Node<K, V> next;

       public Node(K key, V value) {
           this.key = key;
           this.value = value;
       }

       public K getKey(){
           return this.key;
       }
       public V getValue(){
           return this.value;
       }
       public V setValue(V value){
           return this.value = value;
       }
   }

   //fields
    private int size;
    private Node<K, V>[] buckets;
    private static final double LOAD_FACTOR_LIMIT = 0.75;
    private static final int DEFAULT_CAPACITY = 11;
    private static final int SCALE_FACTOR = 2;


    public HashMapPlay(){
        buckets = new Node[DEFAULT_CAPACITY];
    }
      //V put
    public V put(K key, V value){
        int idx = getIndex(key);
        Node<K,V> head = buckets[idx];
        while (head != null){
            //然后对于链表里面的每一个 k，v pair 都要进行比较；那个key是否和input的 key 相同；
            //如果相等，直接覆盖kv pair上面的那个 value；
            if (equalKey(key, head.getKey())){
                V oldValue = head.getValue();
                head.setValue(value);
                return oldValue;
            }
            head = head.next;
        }
        //如果找到链表的尾巴，还是没有找到相等的key，说明key 不存在，我就creat一个新的node，连到链表的头上；
        Node<K,V> newNode = new Node<>(key,value);
        newNode.next = head;
        buckets[idx] = newNode;///在把newnode设置为老头结点
        size++;
        if (((double)size)/buckets.length >= LOAD_FACTOR_LIMIT){
            rehashing();
        }
        return  null;
    }

    /*
    rehashing 要check一下，写的不太一样
     */
    private void rehashing(){
        Node<K, V>[] oldBuckets = buckets;
        buckets = new Node[buckets.length * SCALE_FACTOR];
        for (Node<K,V> node: oldBuckets){
            while (node != null){
                int idx = getIndex(node.getKey());
                node.next = buckets[idx];
                buckets[idx] = node;
                node = node.next;

            }
        }
    }
     // V get(object key)
    public V get(K key){
        int idx = getIndex(key);
        //找到对应的buckets元素对应的head
        Node<K,V> head = buckets[idx];
        while (head != null){
            if (equalKey(key, head.getKey())){
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }

    private int getIndex(K key){
        if (key == null){
            return 0;
            //当key == null 时，永远返回到第0个bucket；因为hashMap 里面允许key ：是null 存在；
        }
        return Math.abs(key.hashCode()) % this.buckets.length;
    }
    private boolean equalKey(K one, K two){
        if (one == null && two == null){
            return true;
        }
        if (one == null || two == null){
            return false;
        }
        return one.equals(two);
    }
//      V remove(K key) 和remove element from linkedlist一模一样，不是从头删
    public V remove(K key){
        int idx = getIndex(key);
        Node<K,V> head = buckets[idx];
        Node<K,V> dummy = new Node<K,V>(null, null);
        Node<K,V> prev = dummy;
        dummy.next = head;
        while (head != null){
            if (equalKey(head.getKey(),key)){
                V returnValue = head.getValue();
                prev.next = head.next;
                size--;
                buckets[idx] = dummy.next;
                return returnValue;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return null;
    }
//    // containsKey
    // 这个containsKey 和 上面的 getkey 很像，为什么不在containsKey 里面直接调用get （key）反而又写一遍呢？
    // 因为有一个很极端的corner case：有可能 user 本身放进去的就是null，【apple，null】containskey 应该返回true，因为包含apple这个key，
    // 但最后得到的本身的vlaue 是null；所以调用get的话，是不work的，并没有考虑，value是null的情况；
    // 如果在containsKey 里面，放入apple，null，重写一遍就会cover 这个极端的corner case；
    public boolean containsKey(K key){
        int idx = getIndex(key);
        Node<K,V> head = buckets[idx];
        while (head != null){
            if (equalKey(key, head.getKey())){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //size
    public int size(){
        return this.size;
    }
    //isEmpty
    public boolean isEmpty(){
        return this.size == 0;
    }
    //clear
    // clear 的意思就是把 buckets 里面都清空，size 变成0
    // buckets扩增之后变得很大了，clear 只会清除里面的数据，并不会把buckets 的number 缩到原来的大小；
    // 所以用 一个 Array 把buckets 里面的全部都fill成null
    public void clear(){
        Arrays.fill(buckets,null);
        this.size = 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i< buckets.length; i++){
            Node<K,V>tmp = buckets[i];
            while (tmp != null){
                sb.append(tmp.getKey() + ":" + tmp.getValue() + ',');
                tmp = tmp.next;
            }
        }
        sb.setCharAt(sb.length() - 1, (char) + '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        HashMapPlay<String, Integer> map  = new HashMapPlay<>();
        System.out.println(map.put("yahoo", 1));
        System.out.println(map.put("yahoo",2));
//        System.out.println(map.put("facebook", 3));
//        System.out.println(map.remove("yahoo"));
//        System.out.println(map.remove("facebook"));

//        System.out.println(map.toString());
//        System.out.println(map.get("google"));
//        System.out.println(map.get("yahoo"));
//        System.out.println(map.containsKey("yahoo"));
//        System.out.println(map.size());

    }


}
