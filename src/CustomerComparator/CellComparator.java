package CustomerComparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CellComparator {

    public static void main(String[] args) {
        PriorityQueue<Cell1> minHeap = new PriorityQueue<>(new MyComprator1());
        Cell1 c1 = new Cell1(0, 0, 3);
        Cell1 c2 = new Cell1(0, 1, 2);
        minHeap.offer(c1);
        minHeap.offer(c2);
        System.out.println(minHeap.poll().value);
        //拿出去的是2；
    }

}


class Cell1 {
    public int value;
    public int rol;
    public int col;



    public Cell1(int rol, int col, int value) {
        this.rol = rol;
        this.col = col;
        this.value = value;
    }

 }

class MyComprator1 implements Comparator<Cell1> {
    @Override
    public int compare(Cell1 o1, Cell1 o2) {
        if (o1.value == o2.value){
            return 0;
        }
        return o1.value< o2.value ? -1:1;
    }

}

