package BitOperation;

public class ReverseBitsof32Integer {
    public long reverseBits(long n){
        long y = 0;
        for (int i = 0; i < 32; i++){
            long lastBit = n & 1;
            n = n >> 1;
            y = (y << 1) + lastBit;
        }
        return y;
    }
    public long reverseBits2(long n) {
        // Write your solution here
        long i = 0;
        long j = 31;
        while ( i < j){
            n = swap (n, i, j);
            i++;
            j--;
        }
        return n;
    }
    //这里的reverse 返回的是一个int
    // 就变成了bit tester =》(X & (1 << K)) ,  (X >> K) &1(recommended)
    private long swap(long n, long i, long j){
        long bi = ((n >> i) & 1); // bit tester
        long bj = ((n >> j) & 1);

        if (bi == bj){
            return n;
        }
        return n ^= ((1L << i) + (1L << j));

    }
}
