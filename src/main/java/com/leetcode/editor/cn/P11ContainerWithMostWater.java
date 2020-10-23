//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1790 👎 0

package com.leetcode.editor.cn;

/**
 * java:[11]盛最多水的容器
 */
public class P11ContainerWithMostWater {

    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        // TO TEST
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {

            // 1.暴力 - 枚举 O(n^2)
            int maxArea = 0;
//            // 记住：第一层 height.length - 1；第二次 height.length；遍历时 int j = i + 1
//            for (int i = 0; i < height.length - 1; i++) {
//                for (int j = i + 1; j < height.length; j++) {
//                    int minHeight = Math.min(height[i], height[j]);
//                    int area = minHeight * (j - i);
//                    maxArea = Math.max(area, maxArea);
//                }
//            }

            // 2.双指针 左右边界i j, 短的边向中间收敛； 也叫 左右夹逼 O(N)
//            for (int i = 0, j = height.length - 1; i < j; ) {
//                // 注意 height[i++] =分解两步=> height[i]; i++;
//                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
//                // 上一步的 i++ 导致 i 多了1步(或 j-- 导致 j 少了1步)，所以做差时少了 1
//                int area = minHeight * (j - i + 1);
//                maxArea = Math.max(area, maxArea);
//            }

            // 3.双指针 精简版
            int start = 0, end = height.length - 1;
            while (start < end) {
                // 此处先计算后再使用i++、j--, 所以无需加 1
                int area = height[start] < height[end] ? (end - start) * height[start++] : (end - start) * height[end--];
                maxArea = Math.max(maxArea, area);
            }

            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}