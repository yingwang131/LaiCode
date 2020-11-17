package String2;

public class charPractice {



    public static void main(String[] args) {
        System.out.println('1' + '2' == '3'); //return false, 应该return 49+50 = 99，99是 'c'
        char i = '1';
        char j = '2';
        System.out.println(i+j);

        char a = '9'; // 57
        char b = '3';// 51
        System.out.println(a-b);

        //convert lower case letter to upper case letter 'd' -> 'D'
        //step1: 找到'd'在alpbet 里面的位置；'d' - 'a' = 3, index= 3 是d
        // step2：再到upper letter 里面去找 D 和 A 的步长，即 3+ 'A' = 3+ 65 = 68；所以68 就是D

        int d = 'd' - 'a';
        char D = (char) (d + 'A');
        System.out.println(d);
        System.out.println(D);
        System.out.println('d' - 'a' + 'A');

    }
}

