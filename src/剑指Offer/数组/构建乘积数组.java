package 剑指Offer.数组;

/**
 * @author 梦仙尘
 * @create 2020-03-28 20:20
 */
public class 构建乘积数组 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
     * 注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];
     */
    public int[] multiply(int[] A) {
        /**
         * 思路
         * 假设给定数组A[4] 构建数组B[4]
         * B[0]:1*A[1]*A[2]*A[3]
         * B[1]:A[0]*1*A[2]*A[3]
         * B[2]:A[0]*A[1]*1*A[3]
         * B[3]:A[0]*A[1]*A[2]*1
         */
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
