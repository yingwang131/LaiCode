package StringBuilderBufferOODCode;

public class StringPrac {

    public static void main(String[] args) {
        StringPrac sol = new StringPrac();
        //String类的构造方法
        byte[] a = {'1','2','3'};
        char[] c = {'1','2'};
        String c1 = new String(c);      //将字符数组转换成字符串
        String a1 = new String(a);      //将byte数组转换成字符串
        String s1 = new String(new StringBuffer("wwe"));//将StringBuffer或StringBuilder转换成字符串

        System.out.println(c1);
        System.out.println(a1);
        System.out.println(s1);


        String[] result = {"abcd.....","bv"};
        System.out.println(result[0]);
        System.out.println("lalalallalalalalalla");
        //具体方法

        /*

        System.out.println(a1.charAt(1));  //返回字符串指定索引出的值
        System.out.println(a1.compareTo("a"));//按照按字典顺序比较两个字符串。返回两个字符串中第一个不同的字符的ascII码差值。 不同于equals
        System.out.println(a1.concat("232")); //jiang指定的字符串连接到字符串的尾部
        System.out.println(a1.contains("123"));//判断是否含指定的字符串
        System.out.println(a1.endsWith("123")); //测试字符串是否已指定的字符结尾
        System.out.println(a1.equals("123"));  //将此字符串与指定对象进行比较。
//
        System.out.println(String.format("%s",a1));//类似于c语言 将字符串进行格式化

        System.out.println("***************************");

        System.out.println(a1.toString());
        char[] c4 = new char[12];
        a1.getChars(1,3,c4,0);  //将此字符串中的字符复制到目标字符数组中
        for (char c0:c4) {
            System.out.println(c0);
        }
//
        System.out.println(a1.length());//返回指定字符串的长度、
//
        System.out.println(a1.replaceAll(a1,"dfg")); //替换字符串中的值

         */

        System.out.println(a1.replace('1','0'));//替换指定字符
        String sp = "a|b|c";
        for (String s : sp.split("\\|")) {   //字符分割 注意特殊字符转义
            System.out.println(s);
        }

        String f = "abcdefg";
        System.out.println(f);
        char[] f1 = f.toCharArray(); //将字符串转换成数组
        System.out.println(f1);
        System.out.println(f.toUpperCase()); //转换成大写
        System.out.println(f.trim()); //去掉空格
        System.out.println(f.valueOf(c)); //将参数转换为字符串

    }

}


