package basicJava;


class ParameterPassing {

    public  int value;
    public ParameterPassing(int v){
        value = v;
    }

}

public class ChangeTest{
    public static void main(String[] args) {
        int x = 5;
        changeIntValue(x);
        System.out.println(x);
    }
    private static void changeIntValue(int y){
        y = 10;
//        x = y;
    }

}

