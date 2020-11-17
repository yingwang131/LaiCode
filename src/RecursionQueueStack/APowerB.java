package RecursionQueueStack;

public class APowerB {
    public long power(int a, int b){
        // 暴力解法,On
        if (b == 0){
            return 1;
        }
//        //subproblem
        long result = 1;
        for (int i = 1; i <=b; i++){
            result=result * a;
        }
        return result;
    }

    public long power1(int a, int b){
        // On
        //this is a recursion: subproblem: f(a, b-1)* f(a,b-2)*....
        // recursion rule : f(a, b-1) * a;
        //base case

        if (b == 0){
            return 1;
        }
        return power1(a, b-1) * a;

    }
    public long power2(int a, int b){
        // O(2^logn - 1 = O(n))\
        // subproblem:
        if (b == 0){
            return 1;
        }
        if (b%2 == 1){

            return power2(a,b/2)*power2(a, b/2)*a;
        }else{
            return power2(a, b/2)*power2(a, b/2);
        }
    }

    //简化一下power2, 这个方法我们并没有用的recursion
    // time： Ologn
    public long power3(int a, int b){
        if (b == 0){
            return 1;
        }
        long tmp = power3(a, b/2);
        if (b % 2 == 1){
            return tmp * tmp * a;
        }else{
            return tmp * tmp;
        }
    }




    public static void main(String[] args) {
        APowerB sol = new APowerB();
        System.out.println(sol.power1(3,5));

    }
}
