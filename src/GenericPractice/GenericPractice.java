package GenericPractice;

public class GenericPractice {

    public static void main(String[] args) {
        People zhao = new RichPeople();
        zhao.eat();
//        zhao.eatLobster();
    }
    /* People zhao = new RichPeople();
    1：类型声明：People       具体实现：richPeople
    2：zhao.eatLobster是错误的：因为zhao能调用谁，取决于People的method，而people里有eat，所以zhao.eat可以用
    3: zhao.eat调用之后，是people的eat，还是richPeople的eat？真正运行的时候，要看zhao实现的的那个class，就是richPeople，
    要看实现的class里面有没有override过这个eat method，如果override过eat，那zhao.eat其实是调用了实现里面override的方法，所以zhao吃的龙虾
     */

}
class People{
    public void eat(){
        System.out.println("hot dog, $ 2.50");
    }
}
class RichPeople extends People{
    public void eatLobster(){
        System.out.println("lobster, $115");
    }
    @Override
    public void eat(){
        eatLobster();
    }
}

