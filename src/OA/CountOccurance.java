package OA;

public class CountOccurance {
    static int numberOf024s(int n){
        int count = 0;
        if (n%10 == 0){
            count++;
        }
        while (n > 0){
            if (n % 10 == 2){
                count++;
            }
            if (n % 10 == 4){
                count++;
            }
            n = n/10;
        }
        return count;
    }
    static int numberOf024sinRange(int n)
    {
        int count = 0;
        for (int i = 0; i <= n; i++){
            count += numberOf024s(i);
        }
        return count;
     }


    public static void main(String[] args) {
        CountOccurance sol = new CountOccurance();
        //10 返回4， 22 返回11， 0 返回1
        System.out.println(sol.numberOf024sinRange(20));
    }
}
