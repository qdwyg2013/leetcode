//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找 
// 👍 337 👎 0

package com.leetcode.editor.cn.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * java:[454]四数相加 II
 */
public class P454FourSumIi {

    public static void main(String[] args) {
        Solution solution = new P454FourSumIi().new Solution();
        // TO TEST


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

            // 方法：hash解法：map
            // 因为只需要返回出现的次数，所以无需记录具体元素
            // key:a+b的数值，value:a+b数值出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            // 遍历大A和大B数组，统计两个数组元素之和出现的次数，放到map中
            for (int a : A) {
                for (int b : B) {
                    int sum = a + b;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }

            // 统计a+b+c+d = 0 出现的次数
            int count = 0;
            // 遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就把map中key对应的value也就是出现次数统计出来。
            for (int c : C) {
                for (int d : D) {
                    int diff = 0 - (c + d);
                    if (map.containsKey(diff)) {
                        // diff 在map的key中出现过几次，则就加相应的数值
                        count += map.get(diff);
                    }
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}