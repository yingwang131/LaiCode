package OA;

import com.sun.tools.javac.Main;

public class TestNewMain {
    Object message(){
        return "Hello!";
    }

    public static void main(String[] args) {
        System.out.print(new TestNewMain().message());
        System.out.print(new Main2().message());
    }
}
class Main2 extends TestNewMain{
    String message(){
        return "World!";
    }
}
