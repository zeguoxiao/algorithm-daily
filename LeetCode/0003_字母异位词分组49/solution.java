//哈希集合
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. 创建 HashMap，key是排序后的字符串，value是原字符串列表
        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            // 2. 将字符串转为字符数组并排序
            char[] sortedS = s.toCharArray();
            Arrays.sort(sortedS);  // 例如 "eat" -> ['a','e','t']

            // 3. 核心方法：computeIfAbsent
            // 如果 key 不存在，则创建新的 ArrayList
            // 如果 key 存在，则返回已有的 ArrayList
            m.computeIfAbsent(new String(sortedS), k -> new ArrayList<>()).add(s);
        }

        // 4. 返回所有分组（HashMap的所有values）
        return new ArrayList<>(m.values());
    }
}



// 这个Lambda表达式实现了 Function 接口
Function<String, List<String>> function = (String key) -> {
    return new ArrayList<>();
};

// 简化写法1：省略参数类型
Function<String, List<String>> function = key -> new ArrayList<>();

// 简化写法2：用 _ 表示参数（不关心参数值）
Function<String, List<String>> function = _ -> new ArrayList<>();

// 最简写法：方法引用
Function<String, List<String>> function = ArrayList::new;
