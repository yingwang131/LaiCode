package BinarySearch;

public class FirstOccurrence {
    public int firstOccur(int[] array, int target){
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0; int right = array.length - 1;
        // 中间要夹一个数，至少不能小于 L M R，最好是 1，2，3，4，如果比3个数还小，就不行了，所以是left < right - 1;
        while (left < right - 1){
            int mid = left + (right - left)/2;
            if (array[mid] == target){
                right = mid;
            }else if(array[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if (array[left] == target){
            return left;
        }
        if (array[right] == target){
            return right;
        }
        return -1;
    }

    public int lastOccur(int[] array, int target){
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0; int right = array.length - 1;
        // 中间要夹一个数，至少不能小于 L M R，最好是 1，2，3，4，如果比3个数还小，就不行了，所以是left < right - 1;
        while (left < right - 1){
            int mid = left + (right - left)/2;
            if (array[mid] == target){
                left = mid;
            }else if(array[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if (array[right] == target){
            return right;
        }
        if (array[left] == target){
            return left;
        }else{
            return -1;
        }
//        if (array[right] == target){
//            //如果不写array[left] == target, 有可能 array[right]的时候，不是target，所以还得做看看， 右看看
//        比如：122258
//            return right;
//        } else{
//            return -1;
//        }
    }





    public static void main(String[] args) {
        FirstOccurrence sol = new FirstOccurrence();
//        int[] array = {1,2,2,2,5,8};
        int[] array = {4,5,5,5,5,5,5};
//        int[]array = {8,10,10,10,12,12}; 这种情况杜宇last来说，postprocessing的时候必须要从array[right]先处理；
//        所以right 和 left 对于firs和last都是有区别的
//        int target = 12;
        int target = 5;
//        System.out.println(sol.firstOccur(array,target));
        System.out.println(sol.lastOccur(array,target));
    }
}
