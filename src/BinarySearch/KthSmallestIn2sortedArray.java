package BinarySearch;

/*
A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */

public class KthSmallestIn2sortedArray {
    public int kth(int[]a, int[]b, int k){
        return kth(a, 0,b,0,k);
    }
    private  int kth(int[]a, int aleft, int[]b, int bleft, int k){
        //base case:如果aleft 比 a的length还大，就返回bleft，但是不会出现这种情况呀，aleft怎么可能比a.length大呢？
        //其实意思是：如果说aleft出界了，说明我的A数组里面一个都不剩，都被删除了；所以直接看B 里面的第k小的元素
        // aleft: 第一个没有被删除的是谁，因为array里面删除要慢死了，所以我不管它删除了多少，只找第一个没有被删除的元素
        if (aleft >= a.length ){
            return b[bleft + k - 1];
        }
        if (bleft >= b.length){
            return a[aleft + k - 1];
        }
        if (k == 1){
            return Math.min(a[aleft], b[bleft]);
        }

        //对于recursive rule 来说，我们首先要找到大的X 和Y

        int amid = aleft + k/2 - 1;
        int bmid = bleft + k/2 - 1;

        //这里integer.maxvalue指的是正无穷，如果amid 出界的话，我还是有想想的空间，把想想的空间设置为正无穷，
        //设置正无穷的目的是为了，当amid < a。length的时候，可以返回a[mid] 的value；
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

        if (aval <= bval){
            // 就把a数组里面，aleft前面的都删掉，原则是：谁小删除谁
            return kth(a, amid+1, b, bleft, k - k/2);
        }else {
            return  kth(a, aleft, b, bmid + 1, k - k/2);
        }
    }

    public static void main(String[] args) {
        KthSmallestIn2sortedArray sol = new KthSmallestIn2sortedArray();
        int a[] = {1,4,5,5,8,12,12,12};
        int b[] = {2,2,3,7,9,9,9};
        int k = 14;
        System.out.println(sol.kth(a,b,k));
    }
}
