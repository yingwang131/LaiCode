package CrossTraing1;

import HashTableStringI.RemoveAdjRepeatedChar2;

import java.util.ArrayDeque;
import java.util.Deque;
/*
"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"

intitial: s = f = 1
case1: a[f]  != a[s-1] copy a[s] = a[f], f++, s++
case 2: a[f] == a[s-1], don’t copy, f++, keeping going until a[f] != a[s-1]; s--;


 */
public class RemoveAdjRepeatedChar2SFpointer {
    public String deDup(String input) {
        char[] array = input.toCharArray();

        if (input == null || input.length() <= 1){
            return input;
        }

        int slow = 1;
        for (int fast = 1; fast < array.length; fast++){
            if ( slow == 0 || array[fast] != array[slow-1]){
                array[slow] = array[fast];
                slow++;
            }else {
//                do{
//                   fast++;
//                }while(fast<array.length&&array[slow-1] == array[fast]);
                //do while 这个写法也不对，因为laicode不认识dowhile，其次 下面的fast + 1一定不能少，因为aa的时候fast就outbound了如果不写fast+1

                while( fast+1<array.length&&array[slow-1] == array[fast+1]){
                    fast++;
                }
                slow--;
            }
        }

        return new String(array, 0, slow);


    }

    public String deDup2(String input) {
        char[] array = input.toCharArray();

        if (input == null || input.length() <=1){
            return input;
        }
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++){
            if (slow == -1|| array[fast] != array[slow]){
                array[++slow] = array[fast];
            }else {
                slow--;
                while (fast+1 < array.length && array[fast] == array[fast+1]){
                    fast++;
                }
            }
        }
        return new String(array, 0, slow+1);
    }
    public static void main(String[] args) {
        RemoveAdjRepeatedChar2SFpointer sol = new RemoveAdjRepeatedChar2SFpointer();
        String input = "abbaaaz";
        String input2 = "aa";
        String input3 = "aababab";
        System.out.println(sol.deDup(input));


    }
}
