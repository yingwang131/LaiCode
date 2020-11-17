package OA;

import queueLinkedList.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// numbers = [1 2 3 4], k = 1; 8 distinct valid subarrays having no more than 1
// ODD element
public class EvenSubarray {
    public int distinctSubarraysAtMostKOdd(int[] nums, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < nums.length; i++) {
            int oddCount = 0;
            sb.setLength(0);

            for (int j = i; j < nums.length; j++) {
                if (isOdd(nums[j])) {
                    oddCount++;
                }

                if (oddCount > k)
                    break;

                sb.append("{").append(nums[j]).append("},");
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    private boolean isOdd(int x) {
        return (x & 1) == 1;
    }


    public static void main(String[] args) {
        test(new int[]{2, 1, 2, 1, 3}, 2, 10);
        test(new int[]{3, 2, 3, 4}, 1, 7);
        test(new int[]{1, 3, 9, 5}, 2, 7);
        test(new int[]{2, 2, 5, 6, 9, 2, 11, 9, 2, 11, 12}, 1, 18);
    }

    private static void test(int[] nums, int k, int expected) {
        EvenSubarray sol = new EvenSubarray();
        int actual = sol.distinctSubarraysAtMostKOdd(nums, k);
        if (actual == expected) {
            System.out.println(actual);
        } else {
            throw new AssertionError(String.format("Expected %d, but actual %d", expected, actual));
        }
    }
}