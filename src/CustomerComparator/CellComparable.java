package CustomerComparator;

import java.util.PriorityQueue;

public class CellComparable {
    public static void main(String[] args) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        Cell c1 = new Cell(0, 0, 3);
        Cell c2 = new Cell(0, 1, 2);
        minHeap.offer(c1);
        minHeap.offer(c2);
        System.out.println(minHeap.poll());
        //拿出去的是2；
    }

}

    class Cell implements Comparable<Cell>{
        private int rol;
        private int col;
        private int value;


        public Cell(int rol, int col, int value){
            this.rol = rol;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Cell o){
            if (this.value == o.value){
                return 0;
            }
            return this.value < o.value ? -1:1;
//            return Integer.compare(this.value, o.value);
        }
    }

