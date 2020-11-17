package StringBuilderBufferOODCode;

public class PolymorphismSample {
    public class Person{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
    public class Employee extends Person{
        private String company;
        public String getCompany(){
            return company;
        }
        public void setCompany(String company){
            this.company = company;
        }
        @Override
        public String getName(){
            return name + "!";
        }
    }

    Employee e = new Employee();
    String name = e.getName();
    String company = e.getCompany();



    Person p = new Employee();//注意，这里p指向的reference 是Person，但new 出来的object 是Employee
//    String company1 = p.getCompany();
    String company2 = ((Employee)p).getCompany();
    /*
    这样子写是错误的，因为p.的reference指向Person，它里面并没有getCompany()；
    那么， Person p = new Employee(); 我们如何用 new 出来的Employee()去拿到getCompany（）呢？
     方法：把P 强制转化成 Employee 的 reference 的类型
     */


    String name1 = p.getName();
    /*
    question: name 1 打印的name 是有！ 还是没有 ！
    答案：是有！号的；
    a： 首先 想要知道.getName(); 能不能被调用；
    所以看  reference 的类型 是Person，所以去person 里面看，person里面正好有 getName(), 所以 我们知道了 getName 是可以被调用的；

    b：getName 被 子类 override 了，而对于已经被 override 的函数，要调用父类 还是 子类， 取决于 object 的类型；
    在这里，object 的类型 是 new Employee()，所以我们要调用子类的版本  即 employee 的 getName， which means 有 感叹号。这个就是polymorphism；

    总结：
    1： 哪些函数能够被调用 取决于 reference 的类型(reference一般指的是等号左边的，而哪些函数能被调用，函数指的是. something，貌似在等号右边)；
    2：对于被override 的 函数，调用哪个版本(父类/子类)，取决于 object 的类型(object 的类型 一般 指的是等号右边的，被new 出来的object)；


     */
}
