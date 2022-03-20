package medium.q31;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description
 * @Author liudeng
 * @Create 2022/3/7 11:38 下午
 **/
public class Test {
    public static void main(String[] args) {


        int[] nums = new int[]{1,2};
        Arrays.stream(nextPermutation(nums)).forEach(e -> System.out.printf(e + "--"));

    }

    public static int[] nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1] ) {
            i--;
        }

        int j = length - 1;
        if (i >= 0) {
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    public static int[] reverse(int[] nums, int start) {
        int length = nums.length - 1;
        while (start < length) {
            swap(nums, start, length);
            start++;
            length--;
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
