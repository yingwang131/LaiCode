package RecursionQueueStack;

import java.util.LinkedList;

public class SortWith3Stacks {
    public static void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        if (s1.isEmpty() || s1.size() == 1) {
            return;
        }
        while (!s1.isEmpty()) {
            int gloM = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                int cur = s1.pop();
                if (gloM > cur) {
                    gloM = cur;
                    count = 1;
                } else if (cur == gloM){
                    count++;
                }
                s2.push(cur);
            } // s1 is empty now
            while (!s2.isEmpty() && s2.peek() >= gloM) {
                int tmp = s2.pop();
                if (tmp != gloM) {
                    s1.push(tmp);
                }
            }
            while (count > 0){
                s3.push(gloM);
                count--;
            }
//            s3.push(gloM);
//            System.out.println(s3.pollFirst());
        }
        while (!s3.isEmpty()) {
            s1.push(s3.pop());
            System.out.println(s1);
        }
    }



    /*
    // 这个方法不但在ide 里面报null pointer exception，还看不懂这个方法，但是laicode就过了
    public static void sort1(LinkedList<Integer> s1){
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        sort1(s1, s2, s3, s1.size());
    }
    private static void sort1(LinkedList<Integer> s1, LinkedList<Integer> s2,LinkedList<Integer> s3, int length){
        if (length <= 1){
            return;
        }
        int mid1 = length/2;
        int mid2 = length - length/2;
        for (int i = 0; i < mid1; i++){
            s2.offerFirst(s1.pollFirst());
        }
        //use the other stacks to sort s2/s1, after sorting the numbers s2/s1 are in ascending order
        sort1(s2,s3,s1,mid1);
        sort1(s1,s3,s2,mid2);
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2){
            if (s2.peekFirst() < s1.peekFirst()){
                s3.offerFirst(s2.pollFirst());
                i++;
            }else{
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while (i < mid1){
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while (j < mid2 ){
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        //after merging, the numbers are in descending order from top to bottom in s3, need push back to s1
        for (int index = 0; index < length; index++){
            s1.offerFirst(s3.pollFirst());
            System.out.println(s1.pollFirst());
        }
//        System.out.println(s1.pollFirst());


}

     */
    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(4);
        s1.push(2);
        s1.push(1);
        s1.push(1);
        s1.push(3);
        s1.push(2);
        sort(s1);

    }
}
