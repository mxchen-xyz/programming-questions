package 剑指Offer.递归和循环;

/**
 * @author 梦仙尘
 * @create 2020-04-03 17:06
 */
public class 斐波那契数列 {
    /**
     * 题目描述
     * 大家都知道斐波那契数列，现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     *
     * n<=39
     */
    public static int Fibonacci(int n) {
        int a = 0;
        int b = 1;
        if(n==0){
            return 0;
        }
        while(--n!=0){
            b = a+b;
            a = b-a;
        }
        return b;
    }
    public static void main(String[] args){
        System.out.println(Fibonacci(6));
    }

}
