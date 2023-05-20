package Work3.H5;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int Search(String S, String[] words) {
        ArrayList<Integer> [] id = new ArrayList[26]; //列表数组，将S分解成26个桶，每个桶存储相应字符的索引位置,比如abca，
                                                        // 那么就存在id[0]列表中，列表存数为[0,3]
        for (int i = 0; i < S.length(); i++) {
            if (id[S.charAt(i) - 'a'] == null)
                id[S.charAt(i) - 'a'] = new ArrayList<>();
            id[S.charAt(i) - 'a'].add(i);
        }

        int count = 0; // 记录是子序列的单词数量，最后输出

        for (String word : words) {
            int x = 0; // 从存放每个字符的列表数组id的最小位置开始查找
            boolean isSubsequence = true;
            for (char c : word.toCharArray()) {
                // 二分查找
                int j = Collections.binarySearch(id[c - 'a'], x);
                if (j < 0) {
                    j = -j - 1;//固定公式，表示应当所在的位置
                }
                if (j == id[c - 'a'].size()) { // 如果找不到满足条件的字符，说明不是子序列
                    isSubsequence = false;
                    break;
                }
                x = id[c - 'a'].get(j) + 1; // 更新x为当前找到的字符位置+1，为下一个字符的查找做准备
            }
            if (isSubsequence) {
                count++; // 如果是子序列，count+1
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(Solution.Search(S, words));
    }
}
