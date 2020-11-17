package HashTableStringI;

public class IfOneStringIsSubString2 {
    public int strsrt(String s1, String s2){
        //这个题目之所以不用toCharArray()是因为返回的并不是一个String 集合，like "abc"，返回的是int，所以不需要
        if (s1 == null || s2 == null || s1.length() < s2.length()){
            return -1;
        }
        if (s2.length() == 0){
            return 0;
        }
        for (int i = 0; i <= s1.length() - s2.length(); i++){
            int j = 0;
            while (j < s2.length() && s1.charAt(i+j) == s2.charAt(j)){
                System.out.println(s1.charAt(i));
                System.out.println(s1.charAt(j));

                System.out.println(s1.charAt(i+j));
                System.out.println(s2.charAt(j));
                System.out.println(s1.charAt(i+j) == s2.charAt(j));
                System.out.println("=========");
                j++;
            }
            if (j == s2.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        IfOneStringIsSubString2 sol = new IfOneStringIsSubString2();
        String s1 = "abcde";
        String s2 = "cde";
        System.out.println(sol.strsrt(s1, s2));
//        System.out.println(s1.charAt(2));

    }
}
