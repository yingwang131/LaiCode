package RecursionQueueStack;

import java.util.ArrayDeque;
import java.util.Queue;

/*laicode没找到这个题目，这个题目写了4个小时把，妈呀debug了一上午，通过了，bug就是在于没有交换reference那就是个雷啊；
这个题写了3个小时还是没写出来；不知道咋办，再回来看看吧；这个题目可以利用size（）这个方法；那要是不能用size怎么做？
push：都放到s1
pop：move all but the last element from q1 to q2;
     poll the last element from q1
     swap the reference of q1 and q2

 */
public class StackBy2Queues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackBy2Queues(){
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    public void push(int x){
        queue1.offer(x);

    }
    public Integer pop(){
        //只有enqueue 和dequeue2个方法，size也不知道
        if (queue1.isEmpty() && queue2.isEmpty()){
            return null;
        }

        if (queue2.isEmpty()){
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
        }//当Q2 不为空的时候，q1只有一个元素，就直接q1.poll就行了；其他的逻辑，在top的时候管控好，每次到pop时。保证q2不为空，q1只有一个元素；
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.poll();
//        Queue<Integer> tem = queue1 = queue2;

    }
    public Integer top(){
        if (queue1.isEmpty()  && queue2.isEmpty()){
            return null;
        }
        if (queue1.isEmpty()){
            while (!queue2.isEmpty()) {//这里q2留一个元素是啥意思
                queue1.offer(queue2.poll());
            }
            while(queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            return queue1.peek();

        }else {
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
        }
        return queue1.peek();
    }
    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        StackBy2Queues sol  = new StackBy2Queues();
        sol.push(1);
        sol.push(2);
        sol.push(3);
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        sol.push(4);
        sol.push(5);
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.top());


        System.out.println(sol.isEmpty());
        //"push(1)", "push(2)", "push(3)", "3", "2", "push(4)", "push(5)", "5", "4", "1", null, null, "true"

    }
}
