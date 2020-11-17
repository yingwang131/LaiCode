package OA;

import jdk.swing.interop.SwingInterOpUtils;

public class Test {
    public static void main(String[] args) {
        /*
        String str = "abcde";
        str.trim();
        str.toUpperCase();
        str.substring(3,4);
        System.out.println(str);


        String c = " IceCream ";
        System.out.println(c.trim());
        String upper = c.toUpperCase();
        System.out.println(upper);
        System.out.println(c);

        String test = " 我是 半角空格,我是半角空格 ";
        System.out.println(test.length());
        System.out.println(test.trim());
        System.out.println(test.trim().length());
        System.out.println(test.replaceAll(" +",""));

//         */

        //Question2：
        String message = "Hello";
        System.out.println(message.length());
        for (int i = 0; i < message.length(); i++){
            System.out.println(message.charAt(i+1));
        }
    }
}
