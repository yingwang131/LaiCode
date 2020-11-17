package basicJava;

public class For {

    public static void main(String[] args) {
        int i = 0;
        for (i = 0; i < 10; i += 3) {
            System.out.println(i + " ");
        }
        System.out.println("The last i is: " + i);
        System.out.println("*********************");

        // 改成while 语句
        int j = 0;
        while(j < 10) {
//            j += 3;
            System.out.println(j);
            j += 3;
        }
        System.out.println("*********************");

        boolean[] arr = {true,false,true};
        for (boolean x:arr
             ) {
            System.out.println(x);
        }
        System.out.println(arr);
        System.out.println("*********************");

        /*
        break:jump out the entire loop
        continue:skip the current iteration
         */
        for (int k=0; k < 2; k++){
            for (int l = 0; l < 5; l++){
                if (l == 2){
//                    break;
                    continue;
                }
                System.out.println(k + ","+ l);
            }
        }

        /*
        continue 在for loop 和 while loop 里面的作用域不一样
        break 和continue 是作用在循环上的，不是if statement，循环指的是while 和for
         */
        for (int m = 0; m < 10; m++){
            if (m == 5){
                continue;
            }
            System.out.println(m);
        }
        System.out.println("*********************");
        int n = 0;
        while (n < 10){
            if (n == 5){
                continue;
            }
            System.out.println(n);
            n++;
        }

    }
}
