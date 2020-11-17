package OA;

import java.util.Vector;

public class  ThreadPrac {
        private  static  int count;
        private static class Thread1 extends Thread {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count ++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Thread1  t1 = new Thread1();
            Thread1  t2 = new Thread1();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(count);
            //1875,1913, 每次的执行结果都不太一样；
            Vector vec = new Vector();
        }
}
