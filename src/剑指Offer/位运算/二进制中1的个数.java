package 剑指Offer.位运算;

/**
 * @author 梦仙尘
 * @create 2020-04-06 17:10
 */
public class 二进制中1的个数 {
    /**
     *题目描述
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public static int NumberOf1(int n) {
        /**
         * 输出该数二进制表示中1的个数便要想到与运算
         * 与运算：如果相对应位都是1，则结果为1，否则为0（有0则0）
         */
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        int a = -8;
        System.out.println(NumberOf1(a));
        System.out.println(Integer.toBinaryString(a));

    }
}
