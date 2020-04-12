package 剑指Offer.数组;

/**
 * @author 梦仙尘
 * @create 2020-03-28 19:58
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        int[][] arr = {{0,1,3,4,5,6},{1,3,4,5,6,7}};
        System.out.println(Find(2,arr));
    }
    /**
     * 题目描述
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static boolean Find(int target, int[][] array) {
        int cols = array.length - 1;//行
        int row = 0;//列
        while (row < array[0].length && cols >= 0) {
            if (target < array[cols][row]) {//最左下角与数比较，当大于时，说明数在最左下角的上面
                cols--;
            } else if (target > array[cols][row]) {//最左下角与数比较，当小于时，说明数在最左下角的右边
                row++;
            } else {
                return true;
            }
        }
        return false;

    }
}

