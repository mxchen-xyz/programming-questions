package 剑指Offer.字符串;

/**
 * @author 梦仙尘
 * @create 2020-03-28 20:40
 */
public class 字符流中第一个不重复的字符 {
    /**
     *题目描述
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 输出描述:
     *
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    String str = "";
    int[] chs = new int[256];
    public void Insert(char ch)
    {
        str += ch;
        if(chs[ch] == 0){
            chs[ch] = 1;
        }else{
            chs[ch]++;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char ch : str.toCharArray()){
            if(chs[ch] == 1){
                return ch;
            }
        }
        return '#';
    }
    public static int FirstNotRepeatingChar(String str) {
        int[] ch = new int[256];
        int temp;
        for(int i = 0;i<str.length();i++){
            temp = str.charAt(i);
            if(ch[temp] == 0){
                ch[temp] = 1;
            }else{
                ch[temp] ++;
            }
        }
        temp = 0;
        for(char strch:str.toCharArray()){
            if(ch[strch] == 1){
                return temp;
            }
            temp++;
        }
        return -1;
    }
    public static void main(String[] args){
        String str = "aaaaccceeddcddddgeeerrr";
        int a =FirstNotRepeatingChar(str);
        System.out.println(a);
    }
}
