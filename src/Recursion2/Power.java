package Recursion2;
/*
Clarify， Assumption，Result ， Test
1：0^0
2: 0^ -2
3: 0^8 = 0
3: 2^ 4
4: 2^ -3
 */
public class Power {
    public double power(int a, int b){
        if (a == 0){
            if (b <= 0){
                return Integer.MIN_VALUE;
            }
            return 0;

        }
        if (b >= 0){
            return powerHelper(a,b);
        }else {
            return 1/(double)powerHelper(a,-b);
        }
    }
    //assume a >=0
    private int powerHelper(int a, int b){
        if (b == 0){
            return 1;
        }
        int tmp = powerHelper(a, b/2);
        return b%2 == 0 ? tmp * tmp : tmp * tmp * a;
    }

    public static void main(String[] args) {
        Power sol = new Power();
//        int a = 0;
//        int b = 0;
//        int a = 0;
//        int b = -2;
//        int a = 0;
//        int b = 8;
//        int a = 2;
//        int b = 4;
        int a = 2;
        int b = -4;



        System.out.println(sol.power(a,b));
    }
}
