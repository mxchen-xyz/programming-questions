package 剑指Offer.代码的完整性;

/**
 * @author 梦仙尘
 */
public class 数值的整数次方 {
    /**
     * 题目描述
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     */
    /**
     * 第一种解法：直接调用库Math中的pow方法
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }

    /**
     * 解法二：暴力法
     * 将数字 base 连续乘 exponent 次即可。
     * 时间复杂度是 O(N),空间复杂度是 O(1)
     * @param base
     * @param exponent
     * @return
     */
    public static double  Power2(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        boolean falg = exponent < 0;//考虑是否为负指数
        int temp = Math.abs(exponent);
        double res = base;
        for(int i = 1;i<temp;i++){
            res *= base;
        }
        return falg ? 1/res : res;
    }
    public static double Power3(double base, int exponent) {

        return Math.pow(base,exponent);
    }
    public static double Power4(double base, int exponent) {

        return Math.pow(base,exponent);
    }
    public static void main(String[] args){
        //第一种的测试
        System.out.println(Power(-5,-3));
        //第二种的测试
        System.out.println(Power2(-5,-3));
        //第三种的测试
        System.out.println(Power3(-5,-3));
        //第四种的测试
        System.out.println(Power4(-5,-3));
    }

}
