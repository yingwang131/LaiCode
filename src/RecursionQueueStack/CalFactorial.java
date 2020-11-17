package RecursionQueueStack;

public class CalFactorial {
    public long factorial(int n){

        if (n <= 0){
            return 0;
        }
        if ( n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        CalFactorial sol = new CalFactorial();
        int n = 5;
        System.out.println(sol.factorial(n));
    }
}
