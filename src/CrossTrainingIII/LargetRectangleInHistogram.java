package CrossTrainingIII;

import java.util.ArrayDeque;
import java.util.Deque;

/*
{ 2, 1, 3, 3, 4 },
the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
linear scan 回头看，用Stack
一但往上升，确定新柱子的左边界，右边界空着；压到Stack
一但往下降，repeated 确定上一题的右边界，左边界空着；不断pop，知道栈顶的元素高度比我小
 */
public class LargetRectangleInHistogram {
    public int largest(int[] array){
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for ( int i = 0; i <= array.length; i++){ // 为什么加等于号和不加等于号差距这么大
            //we need a way to poll all the elements in the stack
            //we explicitly add a bar of height 0;
            int cur = i == array.length ? 0:array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur){
                int height = array[stack.pollFirst()];
                //determine the left boundary of the largest rectangle with height array[i]
                int left = stack.isEmpty() ? 0:stack.peekFirst()+1;
                //determine thee right boundary of the largest rectangle with height of the popped element
                result = Math.max(result,height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LargetRectangleInHistogram sol = new LargetRectangleInHistogram();
        int[] array = {2,1,3,4,5,2,6};
        System.out.println(sol.largest(array));
    }
}
