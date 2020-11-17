package String2;
/*
abc-->cba
 */
public class ReverseString {
    // way1： recursion
    public String reverse(String input){
        if (input == null || input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        helper(array, 0,array.length-1);
        return new String(array);
    }
    private void helper(char[]array, int i, int j){
        if (i >= j){
            return;
        }
        swap(array, i, j);
        helper(array, i+1, j-1); // recursion
    }


    // 第二种方法：iterative
    public String reverse2(String input){
        char[] array = input.toCharArray();
        if (input == null || input.length() == 0 ){
            return input;
        }
        int i = 0, j = array.length -1;
        while (i < j){
            swap(array, i,j);
            i++;
            j--;
        }
        return new String(array);
    }
    private void swap(char[] array, int i, int j ){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void main(String[] args) {
        ReverseString sol = new ReverseString();
        String s = "bca";
        System.out.println(sol.reverse2(s));
    }
}
