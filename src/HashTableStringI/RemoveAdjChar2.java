package HashTableStringI;

public class RemoveAdjChar2 {
    public String deDup(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        if (input == null) {
            return null;
        }
        int i = 0;
        int j = 0;

        while ( j < input.length()){
            if (j==0|| array[j] != array[i-1]){ // j = 0 一定要写，不写就错了，而且！= 写在上面
                array[i++] = array[j++];
            }else {
                j++;
            }
        }

        return new String(array, 0,i);
    }
    public static void main(String[] args) {
        RemoveAdjChar2 sol = new RemoveAdjChar2();
        String input = "aabbbbazw";
        String input2 = " ";
        String input3 = "aa";
        System.out.println(sol.deDup(input2));
    }
}
