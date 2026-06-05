//排序+双指针

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. 排序
        Arrays.sort(nums);
        int n = nums.length;

        // 2. 固定第一个数
        for (int i = 0; i < n - 2; i++) {   //i 的最大值 = n - 3 = 3  因为要留出至少两个位置给 left 和 right
            // 剪枝：如果当前数 > 0，后面的数都大于0，不可能和为0
            if (nums[i] > 0) break;

            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];  //因为nums[i] + nums[left] + nums[right] = 0  所以是负的
            int left = i + 1;
            int right = n - 1;

            // 3. 双指针找另外两个数
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // 找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的 left
                    while (left < right && nums[left] == nums[left + 1]) left++;  //数组下标不能写死，不然输入值改变，就报错 while (left < right && nums[2] == nums[3]) left++;
//                            ↑       ↑
//                         写死了！错误！
                    // 跳过重复的 right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // 移动指针继续找
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}