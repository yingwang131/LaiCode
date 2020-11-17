package DP1;
/*
可以用左大段 右大段
也可用左大段，右小段， 更普遍，但这个题目，这2个方法时间都一样
DP: basecase Induction rule
 */
public class MaxProductOfCuttingRope {
    public int maxProduct(int length){
        //先做左大段右大段，这个是左边查表格，右边也要查表格
        // 大段意思是说，我不在重新计算，用读表格的方式通过读M【i】的值而得到subsolution
        int[] array = new int[length +1];
        //base case
        array[1] = 0;
        for (int i = 2; i <= length; i++){
            int curMax = 0;
            for (int j = 1; j <= i/2; j++){
                //M[3] = max(1,M[1]) * max(2,M[2]) = 1*2 =2
                //M[3] = max(2,M[2]) * max(1,M[1]) = 2*1 =2
                curMax = Math.max(curMax,Math.max(j, array[j]) * Math.max((i-j),array[i-j]));
            }
            array[i] = curMax;
        }
        return array[length];
    }

    public int maxProduct2(int length){
        //左大段右小段，右小段的意思是，不通过查表，而是通过题目已知条件得出
        int[] array = new int[length + 1];
        array[1] = 0;
        for (int i = 2; i <= length; i++){
            int curMax = 0;
            for (int j = 1;j < i; j++){
                //M[3] = max(1,M[1]) * 2) = 1*2 =2
                //M[3] = max(2,M[2]) * 1) = 2*1 =2
                curMax = Math.max(curMax,Math.max(j, array[j]) *(i-j));
            }
            array[i] = curMax;
        }
        return array[length];
    }

}
