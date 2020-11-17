package GenericPractice;

public class GenericArray {
    public static <E>E findMiddle(E[] array){
        int mid = array.length / 2;
        E midElem = array[mid];
        return midElem;
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,5}};
//        int mid = findMiddle(int[]);
//        System.out.println(mid);
     }

     /*
     List<int> wrong
     List<int[]> right,因为generic里面只能放obj不能放primitive type
      */
}
