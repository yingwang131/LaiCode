package basicJava;

public class DesignAnAccumulator {
    /*
    Disign an accumulator
    Design an accumulator, which can take a new integer using function “add”,
    and can return the sum of all taken integers up to now using function “sum”.
     */

    private static int sum = 10;
    public static void add(int x){
        sum += x;
    }
    public static int sumFucntion(){
        return sum;
    }

    public static void main(String[] args){

        int x = 5;
        add(x);
        System.out.println(sumFucntion());


    }
}
