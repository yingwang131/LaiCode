package RecursionQueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class Sort3stacksWebSol {

    static Deque <Double> A = new LinkedList<>();

    public void createStackA() {
        double[] x = {-10,5, 2, 1, 9, 0, 10};
        for (int i = 0; i < x.length; i++)
        {
            A.push(x[i]);
        }
    }

    public void sortStackA(Deque<Double> C) {
        Deque<Double> B = new LinkedList<>();

        while(!C.isEmpty())
        {
            double s1 = (double) C.pop();

            while(!B.isEmpty() && (B.peek() > s1))
            {
                C.push(B.pop());
            }
            B.push(s1);
        }

        System.out.println(B);
        while (!B.isEmpty()){
            A.push(B.pollFirst());
            System.out.println(A);
        }
    }

    public static void main(String[] args)
    {
        Sort3stacksWebSol sS = new Sort3stacksWebSol();
        sS.createStackA();
        sS.sortStackA(A);
    }

}
