package basicJava;

public class Goldbach {

    public static void main(String[] args) {
        int limit = 12;
        goldCheck(limit);

    }
    //gold 猜想：任何一个大于2 的偶数， 可以写成2个质数的和；
    //4=2+2;6=3+3;8=3+5;10=3+7;12=5+7;.....
    //质数：从2开始，除了1和它本身，都被没法被整除，如3，5，7，11，13
    public static void goldCheck(int limit){

        //start at 4 let's check all the odd number
        for (int i = 4; i < limit; i+=2){
            if(canDivided(i)){
                System.out.println(i+"can be divide into two primes.");
            }else{
                System.out.println("congrds, you have win the fields award");
                break;//这个break，就跳出整个for 循环了
            }
        }
    }

    //can be divided by 2 primes sum
    public static boolean canDivided(int n){
        //12: [2,10]; [3,9];  [4,8]; [5,7]; [6,6]; [7,5][8,4][9,3][10,2]拿出来一半数字，来分别判断是不是prime
        for (int i = 2; i<= n/2; i++){
            if(isPrime(i) && isPrime(n - i)){ // i or n?, i 因为重视根据i++来变化，n是一个形参，i是实参
                return true;
            }

        }
        return false;
    }

    public static boolean isPrime(int n){
        for ( int i=2; i*i <= n; i++){
            if ( n % i == 0){
                return false;
            }
        }
        return true;
    }
}
