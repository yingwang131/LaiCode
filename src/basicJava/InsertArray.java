package basicJava;

import java.util.Arrays;

/*
[1,2,3,5]
[1,2,3,6,5]
 */
public class InsertArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,5};
        int position = 3;
        int value = 6;
//        System.out.println(insert(array, position, value).toString());
        System.out.println(Arrays.toString(insert(array, position, value)));
    }

    public static int[] insert(int[] array, int postition, int value){
        //因为要insert一个元素，array的长度不能变，所以要新建一个array
        int[] newArray = new int[array.length+1];
        newArray[postition] = value; //[0,0,0,6,0]
        // directly copy before 6's 123, and after 6's 5
        for (int i = 0; i < postition; i++){
//            array[i] = newArray[i];
            newArray[i] = array[i];
        }
        for(int j = postition+1; j < newArray.length; j++){
            newArray[j] = array[j-1];
        }
        return newArray;
    }
}
