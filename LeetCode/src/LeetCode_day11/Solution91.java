package LeetCode_day11;

import org.junit.Test;

public class Solution91 {

    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1:
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     *
     * 示例 2:
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
     */

    @Test
    public void test(){
        System.out.println(numDecodings("226"));
    }

    public int numDecodings(String s) {
        //dp
        if (s.length()==0||s.equals("0")) return 0;
        if (s.length()==1) return 1;
        int[] v=new int[s.length()+1];
        v[0]=1;
        for (int i=0;i<s.length();i++){
            v[i+1]=s.charAt(i)=='0'?0:v[i];
            if (i>0&&(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<='6')))
                v[i+1]+=v[i-1];
        }
        return v[s.length()];
    }

}
