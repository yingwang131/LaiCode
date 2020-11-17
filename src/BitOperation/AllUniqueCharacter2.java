package BitOperation;

import java.util.HashSet;

public class AllUniqueCharacter2 {
    public boolean allUnique(String word){
        HashSet<Character> set = new HashSet<>();
        for ( int i =0; i < word.length(); i++){
            if (set.contains(word.charAt(i))){
                return false;
            }
            set.add(word.charAt(i));
        }
        return true;
    }
    public boolean allUnique2(String word) {
        boolean[] result = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (result[k]) {
                return false;
            }
            result[k] = true;
        }
        return true;
    }

    //判断set里面的数字是不是1，就变成了bit tester =》(X & (1 << K)) ,  (X >> K) &1(recommended)
    public boolean allUnique3(String word) {
        int occuredChar=0;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (((occuredChar >> k) & 1 ) == 1){ // 这一句就等于allunique里面的set.contains
                return false;
            }
            //bit setter, (x | (1 << k)), 即其他位统统不必,把k位设置成1；
            occuredChar =  occuredChar | (1 << k); // 这一句就等于allUniue里面的set.add（）
        }
        return true;
    }
    //这个版本可以过laicode
    public boolean allUnique4(String word) {
        int[] occor = new int[8];
        for (int i = 0; i < word.length(); i++){
            char k = word.charAt(i);
            int row = k / 32;
            int column = k % 32;
            if (((occor[row] >> column) & 1) == 1){
                return false;
            }
            occor[row] = occor[row] |= (1 << column);
        }
        return true;
    }
    public static void main(String[] args) {
        AllUniqueCharacter2 sol = new  AllUniqueCharacter2();
//        String word = "abcc";
        String word = "/b10{-aAM"; //这个应该返回true，因为是allunique；但是用3 返回的是false
        System.out.println(sol.allUnique4(word));
    }
}
