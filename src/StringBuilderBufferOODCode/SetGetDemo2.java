package StringBuilderBufferOODCode;

public class SetGetDemo2 {
    //这种方法是通过，set() 和 get（）方法来access private field，并没有使用constructor。
    // 这种方法的确定就是，我可以在main函数里，调用对应的set 方法来 更改 name， age；而且用了 set 方法，在field 里面加上final 还有编译错误
    // 而SetGetDemo 是通过constructor 来做的，有了constructor，就不用为那个field 来写 set方法了
    private  String name;
    private  int age;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){ return age; }
    public void setAge(int age){
        this.age = age;
    }

    public static void main(String[] args) {
        SetGetDemo2 sol = new SetGetDemo2();
        sol.setName("Ying");
        sol.setAge(5);
        System.out.println(" the name is " + sol.getName()+ ", the age is " + sol.getAge());

    }
}
