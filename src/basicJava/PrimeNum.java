package basicJava;

public class PrimeNum {


    /*
    判断是不是prime num
     */
    public boolean canDivide(int limit){
        for (int o = 2; o * o <= limit; o++){
            if (limit % o == 0){
                return false;
            }
        }
        return true;
    }

    public int sumOfSquares(int n){
        int sum = 0;
        for (int i = 0; i*i <= n; i++){
            sum += i*i;
        }
        return sum;
    }

    public int sumOfSquares2(int n) {
        // Write your solution here
        int result = 1;
        int sum = 0;
        for (int i = 1; i * i <=n; i++){
            result = i*i;
            sum += result;
        }
        return sum;
    }

    public int factorial(int n) {
        // Write your solution here
        int result =  1;
        for (int i = 1; i <=n; i++){
            result = result * i;
        }
        return result;
    }

    public int power(int a, int b){
        int result = 1;
        for(int i = 1; i <= b; i++){
           result *= a;
        }
        return result;
    }


    public static void main(String[] args){
        PrimeNum sol = new PrimeNum();
        int limit = 9;
        System.out.println(sol.canDivide(limit));

        System.out.println(sol.sumOfSquares(10));

        System.out.println(sol.sumOfSquares2(10));

        System.out.println(sol.factorial(4));
//
//        System.out.println(sol.power(3,4));
    }
}
