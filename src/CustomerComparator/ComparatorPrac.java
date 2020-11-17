package CustomerComparator;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ComparatorPrac {

    public static void main(String[] args) {

        PriorityQueue<Student> minHeap = new PriorityQueue<>(new MyComprator());
        Student s1 = new Student("y", 15);
        Student s2 = new Student("g", 22);
        minHeap.offer(s1);
        minHeap.offer(s2);
        System.out.println(minHeap.poll().getName());

//        String s = "A";
//        System.out.println(s.compareTo("a"));
//


    }
}
    /*
    public class Test{
   public static void main(String args[]){
      Integer x = 5;
      System.out.println(x.compareTo(3));
      System.out.println(x.compareTo(5));
      System.out.println(x.compareTo(8));
     }
    }

    output: 1,0,-1;
     */
class MyComprator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        if (o1.getAge()== o2.getAge()){
            return 0;
        }
        return o1.getAge()< o2.getAge() ? -1:1; // age 是int， 就按interger的order 来比

//            return o1.getName().compareTo(o2.getName()); //name 是string，当然比的是ascii码
    }

}

class Student {
    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName() {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge() {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


}





