package StringBuilderBufferOODCode;

public class differenceBufferBuid {
    public static void main(String[] args) {
        differenceBufferBuid sol = new differenceBufferBuid();
        String str = "asd";
        System.out.println(str);
        str = str + "as";
        System.out.println(str);


        String str2 = "hello,world";
//        String str2 = new String("hello,world");
        System.out.println(str2.replace('h','H'));//这里用buffer时候，str2根本就没有改变嘛,因为string replace是不能改变的，string不能变
        System.out.println(str2.replace('w','W'));
        System.out.println(str2.replaceAll(str2,"not hello world"));


        StringBuffer sb = new StringBuffer("你好，世界");
        sb.replace(0,2,"hello"); // 但是，stringbuffer和stringbuilder是可以变的；
        System.out.println(sb);

        System.out.println("------------------------------");


        StringBuffer stringBuffer = new StringBuffer("梵蒂冈"); //初始容量为16个字符
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());  //所以这里输出的是19
        System.out.println(stringBuffer.append("fds"));
        System.out.println(stringBuffer.delete(3,4)); //删除此序列的子字符串中的字符。
        System.out.println(stringBuffer.insert(3,"f")); //将字符串插入到此字符序列中
        System.out.println(stringBuffer.replace(0,2,"F"));
        System.out.println(stringBuffer.reverse());//反转
        stringBuffer.setCharAt(0,'x');//设置指定索引出的值
        System.out.println(stringBuffer);
    }
}
