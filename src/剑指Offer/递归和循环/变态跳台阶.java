package 剑指Offer.递归和循环;

/**
 * @author 梦仙尘
 * @create 2020-04-03 17:47
 */
public class 变态跳台阶 {
    /**
     *
     一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     求该青蛙跳上一个n级的台阶总共有多少种跳法。

     */
    public static int JumpFloorII(int targg){
        /**
         * 每一级台阶都有跳与不跳两种选择，而最后一级台阶则必须跳，那么便有2的(n-1)次方 种结果
         */
        return 1<<(targg-1);
        /**
         * 按位左移运算符。左操作数按位左移右操作数指定的位数。
         * （左移，左边最高位丢弃，右边补齐0）
         * 结果计算方法（把<<左边的数据乘以2的移动次幂）
         */
    }
    public static void main(String[] args){
        System.out.println(JumpFloorII(1));
    }
}

