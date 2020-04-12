package 剑指Offer.字符串;

/**
 * @author 梦仙尘
 * @create 2020-03-28 20:38
 */
public class 正则表达式匹配 {
    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式.
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false ;
        }
        return matchRecur(str,0,pattern,0);
    }
    public boolean matchRecur(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //匹配成功判断条件：两个坐标分别等于两个字符数组的长度
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败  防止数组越界
        if (strIndex < str.length && patternIndex == pattern.length) {
            return false;
        }
        //当前字符的下一个字符等于'*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //判断当前字符相等还是等于'.'
            if (strIndex < str.length && (pattern[patternIndex] == str[strIndex]||pattern[patternIndex] == '.' )) {
                //有三种情况
                /*
                    1、abc和a*bc patternIndex+2,strIndex+1，相当于*被忽略
	               2、abc和a*abc patternIndex+2，strIndex不变，相当于x*被忽略
	               3、aaaabc和a*abc strIndex+1，patternIndex不变，即继续匹配字符下一位，因为*可以匹配多位
                */
                return matchRecur(str, strIndex, pattern, patternIndex + 2)
                        || matchRecur(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchRecur(str, strIndex + 1, pattern, patternIndex);
            } else {
                //abc 和 ad*bc patternIndex+2，strIndex不变，相当于x*被忽略
                return matchRecur(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //判断当前字符相等还是等于'.'
        if (strIndex < str.length && (pattern[patternIndex] == str[strIndex]||pattern[patternIndex] == '.' )) {
            return matchRecur(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
