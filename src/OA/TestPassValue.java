package OA;

public class TestPassValue {
    public static void main(String[] args) {
        String message = "Hello";
        print(message);
        message += "Word!";
        print(message);
    }
    static void print(String message){

        System.out.print(message);
        message += ' '; // 这里根本就不会运行啊，你瞎啊，妈的

    }
    //hello, hello_world!
    // hello_world!
}
