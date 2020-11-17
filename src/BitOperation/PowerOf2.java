package BitOperation;
/*
16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not

 */
public class PowerOf2 {
    public boolean isPowerOfTwo(int number){
        if (number <= 0){
            return false;
        }
        int numofOnes = 0;
        for ( int i = 0; i < 31; i++){
         numofOnes += (number >> i)&1;
        }
        return numofOnes== 1;
    }

    public boolean isPowerOfTwo2(int number) {
        // Write your solution here
        if (number <= 0){
            return false;
        }
        int count = 0;
        while(number > 0){
            count += number &1;
            number >>>= 1;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        PowerOf2 sol = new PowerOf2();
        int number = 16;
        System.out.println(sol.isPowerOfTwo2(number));
    }
}
