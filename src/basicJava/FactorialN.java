package basicJava;

public class FactorialN {

    public static long getNFactorial1(int n){

        long sum=1;
        for(int i=1;i<=n;i++){
            sum=sum*i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(getNFactorial1(n));
    }
}
