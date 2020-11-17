package StringBuilderBufferOODCode;

import HashTableStringI.IfOneStringIsSubString;

public class StringCharAt {
    public boolean equals(String large, int start, String small){

        for (int j = 0; j <small.length(); j++){
            if (large.charAt(start + j) != small.charAt(j)){

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IfOneStringIsSubString sol = new IfOneStringIsSubString();
        String s1 = "abcde";
        String s2 = "cde";
        int start =2 ;
        System.out.println(sol.equals(s1,start,s2));
    }
}
