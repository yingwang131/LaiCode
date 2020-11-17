package String2;

public class RightShitByNChar {
    public String rightShift(String input, int n) {
        // Write your solution here
        if (input == null || input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
//        reverse(array, array.length -n, array.length -1); // 答案的方法
//        reverse(array, 0, array.length -n-1);
//        reverse(array, 0, array.length -1);

        reverse(array, 0, array.length -1); // 课堂的方法
        reverse(array, 0, n -1);
        reverse(array, n, array.length -1);
        //开始reverse each words by k个
        return new String(array);
    }
    private void reverse(char[] array, int i, int j){
        while(i < j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        RightShitByNChar sol = new RightShitByNChar();
        String s = "abcdef";
        int n = 2;
        System.out.println(sol.rightShift(s,n));
    }
}
