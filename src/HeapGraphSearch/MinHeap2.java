package HeapGraphSearch;

public class MinHeap2 {

    private int size;
    private static final int INIT_CAPCITY = 10;
    private int[] array = new int[INIT_CAPCITY];



    public MinHeap2() {

    }

    //如果我要设定capacity，我需要另一个constructor
    public MinHeap2(int[] NewArray) {
        if (NewArray == null || NewArray.length == 0) {
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


        this.array = NewArray;
        this.size = NewArray.length;
        heapify();
    }

    //offer
    public void offer(int num){
        if (size== array.length){
            expand();
        }
        //先把要offer的元素放到最后一个位置，然后根据大小再perculateUp,直到满足堆序行
        array[size]=num;
        size++;
        perculateUp(size -1);
    }
    //expand
    public void expand(){
        if (size == array.length){
            //如果size已经相同，我就new 一个新的数组
            int[] newArr = new int[(int) (array.length *1.5)];
            // 再一个一个把原来array的元素复制到新的数组
            for (int i = 0; i < newArr.length; i++){
               newArr[i]=array[i];
            }
            //expand之后的数组，就应该是新的数组，再把新数组赋值给老的array,因为一直在用arr操作
            array = newArr;
        }
    }

    public void perculateUp(int index){ //这里传的是最后一个元素的index，只有当index > 0 时才perculateup
        // 如果size = 1， perculateUp（1-1 = 0），一共就一个元素，你还要swap么？所以必须是》0
        while (index > 0){
            int parentIndex = (index -1)/2;
            if (array[parentIndex] <= array[index]){
                swap(array, index, parentIndex);
            }else {
                break;
            }
            index = parentIndex;
        }

    }

    //peak
    public Integer peek(){
        //写Integer 比int好，因为array为空的时候，返回一个null
        if (size == 0){
            return null;
        }
        return array[0];
    }
    //poll
    public Integer poll(){
        if (size == 0){
            return null;
        }
        //先从堆顶把 array[0] 去掉
        int result = array[0];
        // 在把array里面倒数第一个元素给拿到堆顶上去
        array[0] = array[array.length -1];
        size --;
        // 然后再perculate down
        perculateDown(0);
        return result;
    }
    public void perculateDown(int index){
        //l: 2x+1; r:2x+2; p:(x-1)/2
        //step1: 首先要check有没有左右孩子，有可能没有孩子，有可能只有一个左孩子， 不可能只有右孩子，
        // 因为这是一个completedBST并且还要check左右孩子的大小，从小的开始往下swap
        // trick：while结束的条件是：找到最后一个没有儿子的node， 反过来就是找到最后一个有儿子的node
        while (index <= size/2 -1){
            int leftChildIndex = index *2 +1;
            int rightChildIndex = index *2 +2;
            int swapCandicate = leftChildIndex;
            if (rightChildIndex <= size -1 &&  array[rightChildIndex] <= array[leftChildIndex]){
                swapCandicate = rightChildIndex;
            }
            if (array[index] > array[swapCandicate] ){
                swap(array, index, swapCandicate);
            }else {
                break;
            }
            index = swapCandicate; // 接力棒，继续往下swap
        }

    }

    public void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }




    //size
    public int size(){
        return size;
    }
    //isEmpty
    public boolean isEmpty(){
        return size == 0;
    }


    //heapify,放进来的是一个unstored array，我这里要传进去么？no，应该在constructor里面call一次
    public void heapify(){
        //假设是已经有一个arr里面已经有元素了，我把它一次给sort好，都用perculateDown
        for (int i = size/2 - 1; i >=0; i --){
            perculateDown(i);
        }
    }
    //update, return old value. 也可以return 别的，反正这个是我自己定义的api
    public Integer update(int index, int newValue){
        if (index < 0 || index >= size){
            return null;
        }
        //给了index和value，我们就要检查这个input和parent的关系
        // trick 和old value比， > oldValue，向下
        if (newValue > array[index]){
            array[index] = newValue;//这一句不能缺，（index= 1， value = 17）update的例子，要把17先放到index为1的位置上，在pd；
            perculateDown(index);
        }
        if (newValue < array[index]){
            array[index] = newValue;
            perculateUp(index);
        }
        return array[index];
    }

    public static void main(String[] args) {
        MinHeap2 sol = new MinHeap2();
        int array[] = {1, 3, 10, 5, 4, 13,19, 11,8,6};
        sol = new MinHeap2(array);
//        sol.offer(3);
//        System.out.println(sol.poll().toString());
        System.out.println(sol.poll());
        System.out.println(sol.size);
    }

}
