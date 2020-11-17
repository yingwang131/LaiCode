package String2;
/*
“abbcccdeee” → “a1b2c3d1e3”
step 1: 处理从长变短的元素， 比如：ccc -> c3；【b2，C3,e3】
setp 2：处理从 短边长的，即只有一个字母，比如 a -> a1； [a1，d1]
step3: finalize the string by calling resize()

 */
public class CompressString {
    public String compress(String input) {
        // Write your solution here
        if (input == null || input.isEmpty()){
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }
    private String encode(char[] input){
        // step1: deal with the cases where the adjacent occurence of the letters >=2
        int slow = 0;
        int fast = 0;
        int newLength = 0;
        while (fast < input.length){
            int begin = fast;
            // e： begin：12； fast：13 出界
            //就是看到a，fast就往后走，停在不是a的地方：目的是count 有多少个a；
            // 每次都要重新开始，这个begin 是在每次count完之后，又重新开始的；
            while (fast < input.length && input[fast] == input[begin]){
                fast++;
            }
            //这里相当于把 b copy 到 s的位置，因为input[begin]是b，s指向a，
            input[slow] = input[begin];
            slow++;
            if (fast - begin == 1){ //?
                newLength += 2;
            } else {
                int len = copyDigits(input, slow, fast - begin);
                // 这里fast - begin 就是count 出来有几个a，然后去里面的functio，算出len 是几？即几个数字，
                slow += len;// 把返回的数字的长度，和slow相加，把slow 移动到正确的位置；
                newLength += len + 1;// newLenght 就是所有蓝色的结果，这些结果的 长度；
            }
        }
        // step2: letters == 1
        char[] result = new char[newLength];
        fast = slow  - 1;
        slow = newLength - 1;
        while (fast >= 0){
            if (Character.isDigit(input[fast])){
                while (fast >= 0 && Character.isDigit(input[fast])){
                    result[slow] = input[fast];
                    slow--;
                    fast--;
                }
            }else{
                result[slow] = '1';
                slow--;
            }
            result[slow] = input[fast];
            slow--;
            fast--;
        }
        return new String(result);
    }
    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for (int i = count; i >0; i= i/10){//这个i= i/10 到底怎么理解，它是在判断有几位数
            index++; // 这个index++和下面的index -- 必须要写，否则会有其他case过不去；
            len++;
        }
        for (int j = count; j >0; j= j/10){//为什么要写2个 for loop呢？
            System.out.println(j);
            int digit = j % 10;
            index--;
            input[index] = (char)('0' + digit);
            //这里input[index] = 是char类型，意味着一个字母a，但是我想要一个4，还必须是char的类型？
            // 所以  char ss = '0' + 4;// 结果是4，4 是int， 把int 再cast 成 char，即从高精到低精，有风险，需要cast；
            // int 32 位，char是16位，所以长变短有风险，所以需要cast为char
            //因为input是一串字符串，而算出来的digit是个int，但是我的input全部都是字符串，即characters，'0'+ 4 = 4 要把int转化为char，需cast
            //debug 显示： 0->'a'   1->'4' 2->'a' .......
        }
        return len;
    }

    public static void main(String[] args) {
        CompressString sol = new CompressString();
        String input = "aaaabbbcccccef";
//        String input1 = "aaaaaaaaaaaaef";

        System.out.println(sol.compress(input));
        System.out.println("=======================================");


//        char re = '3' + 4;// 结果是7
//        char ss = '0' + 4;// 结果是4
//        int rea = '3'+4;//结果是55； 先算出 3+4 = 7，然后再转化为十进制=》 7 对应 55
//        int resa =(char) '0' + 4; // 结果是52
//        char rr = '3' + '4'; // 十进制 的 3 是51， 4是52， 51+52 = 103 正好是g

        /*
        int i = 0;
        char a = i+'0'; // 这样会编译不通过，必须要cast 成 char
         */

//        char i = '1';
//        System.out.println(i);
//
//        char j = '1';
//        int a = i; // 打印的是 1在assii里面的值49
//        System.out.println(a);
//
//        System.out.println("=======================================");
//        System.out.println(re);
//        System.out.println(ss);
//        System.out.println(rea);
//        System.out.println(resa);
//        System.out.println(rr);

    }
}
