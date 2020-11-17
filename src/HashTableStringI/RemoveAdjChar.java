package HashTableStringI;
/*
“aaaabbbc” is transferred to “abc”: 这种是remove duplicate and adjacent的，aabbbbazw -->abazw,还是有2个a的
 */


public class RemoveAdjChar {
    public String deDup(String input){
        if (input == null){
            return null;
        }
        char[] array = input.toCharArray();
        int i = 0,j=0;
        while (j < array.length){
            if (j==0 || array[j] != array[i-1]){
                array[i++] = array[j++];
            } else {
                j++;
            }
        }
        return new String(array, 0 , i);
    }


    public static void main(String[] args) {
        RemoveAdjChar sol = new RemoveAdjChar();
        String input = "aabbbbazw";
        String input2 = " ";
        System.out.println(sol.deDup(input2));
    }
}
