package StringBuilderBufferOODCode;

public class StringPrac2 {
    public static void main(String[] args) {
        String[] res = {"abc","de"};
        System.out.println(res[0]);

        String s = "yayalala";
        System.out.println(s.toCharArray());

        char[] a = {'a','b','c','d'};
        String s1 = new String(a, 1,2);
        System.out.println(s1);


        char[] a1 = {'a','b','c','d'};
        String s2 = new String(a1,1,3);
        System.out.println(s2);



        char[] a2 = {'s','t','d','e','t','n','t'};
        String s3 = new String(a2,0,5);
        System.out.println(s3);
    }

}
