//哈希集合
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);// 把 nums 转成哈希集合
        }
        int longestStreak = 0;
        for (int num : num_set) { // 遍历哈希集合
            if (!num_set.contains(num - 1)) {// 只从序列的最小值开始统计
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}

HashSet 常用方法总结
1. 基本操作
方法	说明	返回值	时间复杂度
add(E e)	添加元素	boolean（是否添加成功）	O(1)
remove(Object o)	删除元素	boolean（是否存在并删除）	O(1)
contains(Object o)	判断是否包含	boolean	O(1)
clear()	清空所有元素	void	O(n)
isEmpty()	判断是否为空	boolean	O(1)
size()	返回元素个数	int	O(1)
2. 批量操作
方法	说明	时间复杂度
addAll(Collection c)	添加集合中的所有元素	O(n)
removeAll(Collection c)	删除集合中存在的元素	O(n)
retainAll(Collection c)	只保留两个集合的交集	O(n)
containsAll(Collection c)	判断是否包含所有元素	O(n)
        3. 遍历方法
方法	说明
iterator()	返回迭代器
forEach(Consumer action)	JDK8 遍历
4. 其他方法
方法	说明
toArray()	转换为数组
clone()	浅拷贝
equals(Object o)	比较是否相等
hashCode()	返回哈希码



用 HashSet 的原因主要有以下几点：
O(1) 的查找时间
自动去重
需要频繁判断：当前数的前后是否存在
while (numSet.contains(currentNum + 1))



