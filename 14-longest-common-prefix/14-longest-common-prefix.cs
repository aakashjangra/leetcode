public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        if (strs.Length == 0) {
            return "";
        }
        if (strs.Length == 1) {
            return strs[0];
        }
        Array.Sort(strs);
        string prefix = "";
        for (int i = 0; i < strs[0].Length; i++) {
            if (strs[0][i] == strs[strs.Length - 1][i]) {
                prefix += strs[0][i];
            } else {
                break;
            }
        }
        return prefix;
    }
}