package CrossTrainingIII;
/*
{ 2, 1, 3, 2, 4 },  题目看不懂呀，说用中心开花
the amount of water can be trapped is 1 + 1 = 2
(at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
 */
public class MaxWaterTrappedI {
    public int maxTrapped(int[] array){
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length -1;
        int result = 0;
        int lmax = array[left];
        int rmax = array[right];
        while (left < right){
            if (array[left] <= array[right]){
                result = result + Math.max(0, lmax - array[left]);
                lmax = Math.max(lmax, array[left]);
                left++;
            }else {
                result = result + Math.max(0, rmax - array[right]);
                rmax = Math.max(rmax, array[right]);
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxWaterTrappedI sol = new MaxWaterTrappedI();
        int[] array = {2, 1, 3, 2, 4 };
        System.out.println(sol.maxTrapped(array));
    }
}
