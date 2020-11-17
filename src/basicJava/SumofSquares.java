package basicJava;

import java.util.ArrayList;
import java.util.List;

public class SumofSquares {

    public int sumOfSquared(List<Integer> list){
        if (list == null || list.isEmpty() == true){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++){
            sum += list.get(i) * list.get(i);
        }
        return sum;
    }

    public boolean areEqual(int x, int y){
        return x == y;
    }
    public static void main(String[] args){
        SumofSquares sol = new SumofSquares();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(sol.sumOfSquared(list));
    }



}
