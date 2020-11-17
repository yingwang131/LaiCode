package GenericPractice;

public class MyPair<k,v> {

    private k key;
    private v value;

    public MyPair(k key, v value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyPair[key=" + key + ", value=" + value + "]";
    }

    public void setKey(k key) {
        this.key = key;
    }

    public void setValue(v value) {
        this.value = value;
    }

    public k getKey() {
        return key;
    }

    public v getValue() {
        return value;
    }
}
    class Util{
    public static <k,v> boolean myequal(MyPair<k,v> p1, MyPair<k,v> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

    class GnenricMethod2{
        public static void main(String[] args) {
            MyPair<String,Integer> p1 = new MyPair<String, Integer>("a", 1);
            MyPair<String,Integer> p2 = new MyPair<String, Integer>("b", 2);
            MyPair<String,Integer> p3 = new MyPair<String, Integer>("a", 1);
            MyPair<Character,Integer> p4 = new MyPair<Character, Integer>('a', 1);

            System.out.println(p1 + "cpmpared with" + p2 + " : " + Util.myequal(p1,p2));
            //因为用了util的equal方法，所以必须是key和value严格相等，所以false

            System.out.println(p1 + "cpmpared with" + p3 + " : " + p1.equals(p3));
            //这里用了object的equals，比较的是地址，所以肯定是不一样的地址，即便key value一样；

//            System.out.println(p1 + "cpmpared with" + p4 + " : " + Util.myequal(p1,p4));
            // 直接在compile的时候报错，因为generic的类型不一样，是不能比较的；
        }
    }


