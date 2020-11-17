package StringBuilderBufferOODCode;

public class Stringbuid {
    //append,insert, toString(), length;
    public static void main(String[] args) {
       Stringbuid sol = new Stringbuid();

       StringBuilder str = new StringBuilder();
       str.append("hello");
       str.append(" immoc");
       str.append(123);
       System.out.println("the string length is " + str.length());

       str.insert(3, "ying");
       str.insert(5, 9);
//       System.out.println(str);
//
//        System.out.println(str.toString());
        String str2 = str.toString(); //转化为string的对象
        System.out.println("插入后 " + str2);


/*
String a = "ABCabc";
System.out.println("a = " + a);
a = a.replace('A', 'a');
System.out.println("a = " + a);
 打印结果为： a = ABCabc

a = aBCabc

那么a的值看似改变了，其实也是同样的误区。再次说明， a只是一个引用， 不是真正的字符串对象，在调用a.replace('A', 'a')时， 方法内部创建了一个新的String对象，并把这个心的

对象重新赋给了引用a。String中replace方法的源码可以说明问题 最后return new String(buf， true)；
 */

    }
}
