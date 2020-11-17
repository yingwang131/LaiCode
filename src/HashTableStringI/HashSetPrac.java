package HashTableStringI;

import java.util.HashSet;
import java.util.Iterator;
/*
HashSet的一些常用方法：

添加元素：

hashset.add(E e)：返回boolean型，如果此 set 中尚未包含指定元素，则添加指定元素；如果此 set 已包含该元素，则该调用不更改 set 并返回 false。

删除元素：

hashset.clear()：从此 set 中移除所有元素。

hashset.remove(Object o)：如果指定元素存在于此 set 中，则将其移除。

hashset.isEmpty()：如果此 set 不包含任何元素，则返回 true。

hashset.contains(Object o)：如果此 set 包含指定元素，则返回 true。

hashset.size()：返回此 set 中的元素的数量（set 的容量）。

 */

public class HashSetPrac {

    public static void main(String[] args) {


        HashSet<Integer> set =new HashSet<>();
        set.add(22);
        set.add(3);
        set.add(8);

        //遍历这个hashset
        //1.foreach
        for (Integer integer : set) {
            System.out.println(integer);
        }
        System.out.println("*************************");
        //2.迭代器
        Iterator<Integer> iterator=set.iterator();
        while(iterator.hasNext()){
            Integer integer=iterator.next();
            System.out.println(integer);
        }
        System.out.println("*************************");
        //对比查找
        System.out.println(set.contains(22));

        //清空
        set.clear();

        //获取长度
        System.out.println(set.size());







    }

}


