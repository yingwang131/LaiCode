package String2;

public class CompressStr {
        public String compress(String input) {
            // Write your solution here
            if (input == null) {
                return input;
            }
            char[] array = input.toCharArray();
            return encode(array);
        }

        private String encode(char[] array) {
            int slow = 0, fast = 0, begin = 0, newLength = 0;
            while (fast < array.length) {
                begin = fast;
                while (fast < array.length && array[fast] == array[begin]) {
                    fast++;
                }
                array[slow] = array[begin];
                slow++;

                if (fast - begin == 1) {
                    newLength += 2;
                } else {
                    //need compress aaaa to 4
                    int len = copyDigit(array, slow, fast - begin);
                    slow = slow + len;
                    newLength += len + 1;
                }
            }

            //deal with letter ==1 e f => e1f1
            char[] result = new char[newLength];
            fast = slow - 1;
            slow = newLength - 1;
            while (fast >= 0) {
                if (Character.isDigit(array[fast])) {
                    //这个while 不加是错的，如果是a13b11u1，fast指向digit的时候，可能有好几位digit，不仅仅是一位数啊，所以得遍历
                    // while(fast >=0 && Character.isDigit(array[fast])){
                    result[slow] = array[fast];
                    slow--;
                    fast--;
                    // }

                } else {
                    result[slow] = '1';
                    slow--;
                }
                result[slow] = array[fast];
                slow--;
                fast--;
            }
            return new String(result);
        }

        private int copyDigit(char[] array, int index, int count) {
            int len = 0;
            // decide the len 是个几位数，2位or3位
            for (int i = count; i > 0; i /= 10) {
                index++;
                len++;
            }
            //把这个位数给写上去，比如是2位，12，要把1 和2写到这个array上；
            for (int i = count; i > 0; i /= 10) {
                int digit = i % 10;
                index--;
                array[index] = (char) ('0' + digit);
            }
            return len;
        }

    public static void main(String[] args) {
        CompressStr sol = new CompressStr();
        String input = "aaaabbbcccccef";
        String input1 = "oooooooooooogggggggttttttttttuuuuuuuuuuyyyyyyyhhhhhhh";

        System.out.println(sol.compress(input1));
        System.out.println("=======================================");

    }
}

