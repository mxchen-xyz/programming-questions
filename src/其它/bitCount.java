package 其它;

import java.util.Scanner;

/**
 * @author 梦仙尘
 * @create 2020-04-03 16:10
 */
public class bitCount {
    /**
     * 题目描述
     * 输入一个long类型的数值, 求该数值的二进制表示中的1的个数 .
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        System.out.println(count);
        in.close();


    }
}
