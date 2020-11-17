package HeapGraphSearch;

public class MinHeap {
    private int[] array; // 因为这个 int【】array是一个实现细节，不应该暴露给user，user可能会直接改动这个array，那就错了
    private int size;

    public MinHeap() {

    }

    //如果我要设定capacity，我需要另一个constructor
    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        // 这里做deep copy 比较好：因为对于一个heap而言，public api 是offer，peek，poll，这个array 是一个实现细节不应该expose给user，
        // 所以把array 弄成了private，size也是private
        // 如果不是private的话，user可以直接改动array，这个pq就完全错了；
        // deep copy：就是把array 一个一个的copy 的拷贝过去；
//
//        int[]newArray = new int[array.length];
//         for (int i = 0; i < array.length; i++){
//                 newArray[i] = array[i];
//         }


        this.array = array;
        this.size = array.length;
        heapify();
    }

    // heapify
    // 因为heapify 是一次性的把unsorted array 变成一个heap
    private void heapify() {
        // 从第一个internal node 开始：即 size/2 -1;  向下swap；因为向下swap 所以index >= 0；
        // 因为internal node 的执行方向，是递减的，所以是i--；
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public void offer(int ele) {
        // offer 用到percularUp
        // poll，heapify，update：用到percularDown
        // 但offer 和poll 步骤差不多，但是offer比poll要多一步expand
        if (size == array.length) {
            expand();
        }
        // 把这个 要offer 的元素放到 array 里面最后一个位置；其实就是null的位置，也是expand之后的位置，
        array[size] = ele;
        // 注意只有先 size ++ ； 最右一个元素才可能是 size -1；
        // 如果 后 size++ 的话，最右一个percolateUp 的时候，最右一个元素就变成size 了
        size++;
        percolateUp(size - 1);
    }

    public void expand() {
        if (size == array.length) {
            int[] newArray = new int[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    //// 删除的时候是：把右下角的元素拿上来，percular down
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public Integer peek() {
        return array[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer update(int index, int ele) {
        //差一下index 不是outofbound
        if (index < 0 || index >= size) {
            return null;
        }
        //update 是和oldvalue 来比较，如果比oldvalue小的话，有可能percularUp，这个方法里面已经包括了比较，不用自己再写了
        // 如果比oldvalue大的话，有可能percularDown，这个方法也已经写过了
        int oldVlaue = array[index];
        array[index] = ele;
        if (oldVlaue > ele) {
            //还要把这个index上的值给替换一下，再进行swap
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        //最后要return oldValue；所以要用先存一下oldvale的值；
        return oldVlaue;
    }

    public void percolateDown(int index) {
        // step 1: check if index is legal? 有没有左儿子，有没有右儿子，可能这个index 没有儿子； 如果左右儿子都有的情况下，我还要看哪个儿子小，我就和哪个swap；
        // 我们这个while loop 写到 让这个index 到达最后一个没有儿子的node 我们就停止；
        // 那么 反过来，最右一个有儿子的node； 举个例子在poll 的图示里面是 5，如果最后一个有儿子的node 是5 的话，这个5 node 刚好就是一个parent；就是最后一个node 的parent（也就是8）
        // 最后一个node的index 是：size - 1； parent： （x-1）/2;  即：(（size -1) - 1 )/ 2 = (size -2)/2 = size/2 - 1;
        // 所以我们得到了最右一个有儿子的node是size/2 - 1，那么while的停止条件 从 到达最后一个没有儿子的node就停止， ==  找到到达最右一个有儿子的node，再往下我就不care了，而且有儿子的node好实现而已
        // 这么写的好处是： 保证左儿子一定存在；不用那么多if 来check 是不是有左右儿子；
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            // 我们可以 建一个candidate，最开始的candidate 可以假设成leftChildInde， 因为leftchild 一定存在；（气泡往左挤，所以左边的一定先存在）
            int swapCandicate = leftChildIndex;
            // 如果右儿子也存在 且 右儿子 比较小，我们就swap 右儿子和candidate；否则，就swap 左孩子；
            // 经过这个if，我们很容易的找到了  最小的那个孩子，记住，是找到了要swap的candidate，并没有swap呢；
            if (rightChildIndex <= size - 1 && array[rightChildIndex] <= array[leftChildIndex]) {
                swapCandicate = rightChildIndex;
            }
            if (array[index] > array[swapCandicate]) {
                //这个array[index]就是指要删除的那个元素的index 的值，如果要删除的元素比孩子大，那就swap，如果比孩子小的话，那就结束这个循环；

                swap(array, swapCandicate, index);
            } else {
                break;
            }
            index = swapCandicate;
            //把index 换成swapcandicate的原因是，当我把较大的顶部的元素换到孩子的时候，我需要把那个换下来的大的元素继续往下面找小的孩子进行交换
        }
    }

    public void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            // 因为percularUp的时候，只有一个candicate，所以换的时候不用判断左右孩子的大小简单一点
            if (array[index] < array[parentIndex]) {
                swap(array, index, parentIndex);
            } else {
                break;//continue    在while 里面都一样
            }
            index = parentIndex;
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        MinHeap sol = new MinHeap();
        int array[] = {10, 29, 12, 5, 7, 14,6};
        sol = new MinHeap(array);
//        sol.offer(3);
//        System.out.println(sol.poll().toString());
        System.out.println(sol.update(1,4));
        System.out.println(sol.size);
    }
}
