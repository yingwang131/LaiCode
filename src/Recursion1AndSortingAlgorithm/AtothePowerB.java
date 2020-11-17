package Recursion1AndSortingAlgorithm;
/*
recursion
base case: b == 0; return 1;
recursion rule:
 */
public class AtothePowerB {
    //time: On, space: On
    public long power(int a, int b){
        if ( b ==0){
            return 1;
        }
        if (b < 0){
            return (long) 0;
        }
        return a * power(a, b-1);
    }
    public long power1(int a, int b){
        //Time： On
        // Space：用了recursion，recursion tree 明显劈了一半因为/2， 看直上直下的粉红色路径（看callStack），logn；
        // laicode 不接受这个答案，说too many recursion
        if (b == 0){
            return 1;
        }else  if ( b == 1){
            return a;
        }
        long mid = b / 2;
        return power1(a, (int) mid) * power1(a, (int) (b - mid));
    }

    public long power2(int a, int b){
        //Time： On
        // Space：用了recursion，recursion tree 明显劈了一半因为/2， 看直上直下的粉红色路径（看callStack），logn；
        // laicode 不接受这个答案，说too many recursion
        if (b == 0){
            return 1;
        }
        if(b % 2 == 0){
            return power2(a, b/2) * power2(a, b/2);
        }else{
            return power2(a, b/2) * power2(a, b/2) * a;
        }
    }
    public long power3(int a, int b){
        //试试时间能不能降一下；
        // time: logn
        // space: logn, laicode 接受哦；
        if(b == 0){
            return 1;
        }
        long temp = power3(a, b/2);
        if (b % 2 == 0){
            return temp*temp;
        }else{
            return temp*temp*a;
        }
    }
    //考虑这些corner case：0^0，0^-2,0^8=0, 2^-3
    public double power4(int a, int b) {
       if ( a == 0){
           if ( b <= 0){
               return Integer.MIN_VALUE;
           }else {
               return 0;
           }
       }
       if (b < 0){
           return 1 / powerHeper(a, b);
       }
        return powerHeper(a,b);
    }

        //assume b >= 0;
        private long powerHeper ( int a, int b){
            if (b == 0){
                return 1;
            }
            long tmp = powerHeper(a, b/2);
            if (b%2 == 0){

                return tmp * tmp;
            }else{
                return tmp * tmp * a;
            }
        }



    public static void main(String[] args) {
        AtothePowerB sol = new AtothePowerB();

        // 0^0，0^-2,0^8=0, 2^-3
        int a = 2;
        int b = -3;
        System.out.println(sol.power4(a,b));
    }
}
