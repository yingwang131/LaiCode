package String2;

public class CopyDigits {
    public int copyDigits(char[] input, int index, int count){
        int len = 0;
        for (int i = count; i >0; i= i/10){
            index++;
            len++;
//            System.out.println(i);
            //为什么打出来 12，1, 因为12/10=1, 1/10=0, 到第二轮i increment之后 i = 0，i > 0 无法满足，所以无法进入循环，循环结束
            //所以说这个for loop 是在判断有几位数，12 的话， len就是2；
        }

        //第二个for loop 是在算digit，也就是说先算digit= 12%10 = 2，digit = 1%10 = 1；每次index--，
        // 先把2放在后面，再把1放在2前面，就是12，最后input 就是：a12aaaaaaaaa
        for (int i = count; i >0; i= i/10){
            int digit = i % 10; // digit = 2， 1
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
        CopyDigits sol = new CopyDigits();
        char[]input = {'a','a','a','a','a','a','a','a','a','a','a','a'};
        int index = 1;
        int count = 12;
        System.out.println(sol.copyDigits(input,index,count));
        System.out.println(input);
        System.out.println("*******");
        System.out.println(12/10);// 12/10 = 1,
        System.out.println(1/10);//1/10 = 0

    }
}
