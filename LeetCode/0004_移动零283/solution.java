//双指针
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;  // 指向下一个非零元素应该放的位置

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // 交换非零元素到 left 位置
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
//