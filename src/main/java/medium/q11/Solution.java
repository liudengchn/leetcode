package medium.q11;

/**
 * @ClassName Solution
 * @Description
 * @Author liudeng
 * @Create 2022/3/4 12:33 上午
 **/
class Solution {
    public static void main(String[] args) {
        int[] height = new int[]{2,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height.length == 1) {
            return height[0];
        }

        int i = 0;
        int j = height.length - 1;
        int result  = 0;
        while (i < j) {
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));

            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
