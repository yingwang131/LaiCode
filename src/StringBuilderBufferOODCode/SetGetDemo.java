package StringBuilderBufferOODCode;
// 私有的属性，可以通过 set() get()调用；也可以通过构造函数调用
public class SetGetDemo {
    private final String name;
    private  int age;
    //这种方法是通过，constructor 和 get（）方法来access private field
    public SetGetDemo(String name, int age){
        this.name = name;
        this.age = age;
    }
    //有constructor这样更安全，因为私有的属性只能通过 getName 去访问，
    //上面这句话有歧义，如果想给私有和公有属性 赋值，我们都需要 用get方法来传入值，并返回相应的值；
    // 总结：有了constructor 所包括的field，就不用再为那个field 来写 set方法了，直接从new object 里面传入值，通过get 方法读取出来
    public String getName(){
        return "my name is" + name;
    }
    public int getAge(){
        return age;
    }

    public static void main(String[] args) {
        SetGetDemo sol = new SetGetDemo(" ying wang",5);
//        sol.name = "ll"; // 如果改为：private String name; sol.name 就会出现编译错误[can not assign a value to final variable]
        sol.age = 3;
        System.out.println(sol.getName());
        System.out.println(sol.getAge());

    }
}
