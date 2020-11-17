package BitOperation;
/*
5(“0101”) and 8(“1000”) has 3 different bits
 */
public class NumberOfDifBits {
    public int deffBits(int a, int b){
        int n = a ^ b;
        int count = 0;
        while(n != 0){
            count += n & 1;
            n >>>=1; // 等价于n = n >>> 1;
        }
        return count;
    }
}
