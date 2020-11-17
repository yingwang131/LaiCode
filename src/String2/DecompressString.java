package String2;

public class DecompressString {
    public String decompress(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            char ch = array[i];
            i++; // 这里很巧妙啊，取出character 之后，i++，就到数字那一栏了；
            System.out.println(array[i]);
            int count = array[i] - '0';//这里的count 是看字母后面的那个数字是几，是5 就下一个for 循环打印5次；'1' - '0' = 1
            for (int c =0; c < count; c++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        DecompressString sol = new DecompressString();
        String input = "a1c0b2c4";
        System.out.println(sol.decompress(input));
    }
}
