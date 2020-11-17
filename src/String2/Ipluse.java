package String2;

public class Ipluse {
     // i++ 先赋值在运算,例如 a=i++,先赋值a=i,后运算i=i+1,所以结果是a==1
    //  ++i 先运算在赋值,例如 a=++i,先运算i=i+1,后赋值a=i,所以结果是a==2
    public static void main(String[] args) {
        // i++和++i的区别
        int i = 1;
        int a =0;
        System.out.println(a = i++); // a = 1， 先赋值：a=1; 后运算： i = i+1 => i = 1+1=2；
        System.out.println(a = ++i); // a = 3， 先运算：i=i+1=> i= 2+1=3; 后赋值：a=3；

        System.out.println("*************************");
        int y=0;
        int x =0;
        y=++y;
        y=++y;
        y=++y;
        y=++y;
        y=++y;
        System.out.println("y="+y); //y=5
        x=x++;
        x=x++;
        x=x++;
        x=x++;
        x=x++;
        System.out.println("x="+x);//x=0



    }


}
