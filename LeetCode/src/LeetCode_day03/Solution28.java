package LeetCode_day03;

import org.junit.Rule;
import org.junit.Test;

public class Solution28 {

    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
     * (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf()
     * 定义相符。
     */
    @Test
    public void test(){
        System.out.println(strStr("mississippi","issip"));
    }

    //KMP模式匹配算法
    public int strStr(String haystack, String needle) {
        if (haystack==null||haystack.length()==0||needle==null||needle.length()==0){
            return 0;
        }
        //求next数组
        int[] next=new int[needle.length()];
        next[0]=-1;
        for (int i=1;i<needle.length();i++){
            int t=next[i-1];
            while (needle.charAt(t+1)!=needle.charAt(i)&&t>=0){
                t=next[t];
            }
            if (needle.charAt(t+1)==needle.charAt(i)){
                next[i]=t+1;
            }else {
                next[i]=-1;
            }
        }
        //kmp匹配
        int i=0,j=0;
        while (i<haystack.length()&&j<needle.length()){
            if (j==-1||haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                if (j==0) i++;
                else j=next[j-1]+1;
            }
        }
        if (j==needle.length()){
            return i-j;
        }else {
            return -1;
        }
    }

}
